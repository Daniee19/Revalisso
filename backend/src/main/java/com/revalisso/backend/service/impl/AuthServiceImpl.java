package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.ChangePasswordRequest;
import com.revalisso.backend.dto.LoginRequest;
import com.revalisso.backend.dto.RegisterRequest;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.PersonaRepository;
import com.revalisso.backend.service.CustomUserDetails;
import com.revalisso.backend.service.IAuthService;
import com.revalisso.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean changePassword(ChangePasswordRequest request) {

        Persona persona = personaRepository.findByCorreo(request.getCorreo()).orElseThrow(()-> new RuntimeException("Correo no encontrado"));

        // Verificamos la contraseña antigua
        if (!passwordEncoder.matches(request.getOldPassword(), persona.getPassword())) {
            return false; // contraseña incorrecta
        }
        // Cambiamos la contraseña
        persona.setPassword(passwordEncoder.encode(request.getNewPassword()));
        personaRepository.save(persona);

        return true;
    }

    //El RegisterRequest es un DTO de Persona
    @Override
    public String register(RegisterRequest request) {
        Persona persona = Persona.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .celular(request.getCelular())
                .password(passwordEncoder.encode(request.getPassword()))
                .correo(request.getCorreo())
                .build();
        personaRepository.save(persona);
        return "Registrado exitosamente";
    }

    //Es como decir ve a la clase que está implementando a la interface UserDetailsService

    @Autowired
    private JwtService jwtService;
    //El LoginRequest es un DTO de Persona
    @Override
    public String login(LoginRequest request) {
        System.out.println("El correo es: " + request.getCorreo());
        //El uso del "orElseThrow", hace que se rompa el optional y se trabaje con la clase directo, sin tener que usar el Optional<Persona>
        //1. Autenticar usuario
        Persona persona = personaRepository.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Correo no registrado"));

        //Se compara la contraseña ingresada (texto plano), con la contraseña hasheada de la base de datos
        if (!passwordEncoder.matches(request.getPassword(), persona.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        //2. Cargar UserDetails
        UserDetails userDetails = new CustomUserDetails(persona); //El userDetailsService implícitamente está yendo a la clase que implementa la interface UserDetailsService

        //3. Devolver el token
        return jwtService.generateToken(userDetails);
    }
}