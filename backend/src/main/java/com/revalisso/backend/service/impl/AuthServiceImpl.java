package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.ChangePasswordRequest;
import com.revalisso.backend.dto.LoginRequest;
import com.revalisso.backend.dto.RegisterRequest;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.entity.Rol;
import com.revalisso.backend.repository.PersonaRepository;
import com.revalisso.backend.repository.RolRepository;
import com.revalisso.backend.service.CustomUserDetails;
import com.revalisso.backend.service.IAuthService;
import com.revalisso.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public boolean changePassword(ChangePasswordRequest request) {

        Persona persona = personaRepository.findByCorreo(request.getCorreo()).orElseThrow(() -> new RuntimeException("Correo no encontrado"));

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
    public ResponseEntity<?> register(RegisterRequest request) {


        //Si el id no se menciona entonces es 1 (ROL DE USUARIO)
        Long rolId = request.getRol() != null ? request.getRol() : 1L;

        Rol rolecito = rolRepository.findById(rolId).orElseThrow(() ->
                new RuntimeException("Rol no encontrado"));


        Persona persona = Persona.builder()
                .nombre(request.getNombres())
                .apellido(request.getApellidos())
                .celular(request.getCelular())
                .password(passwordEncoder.encode(request.getPassword()))
                .correo(request.getCorreo())
                .rol(rolecito)
                .build();


        personaRepository.save(persona);
        return ResponseEntity.ok(Map.of("mensaje", "El usuario se ha registrado correctamente"));
    }

    //Es como decir ve a la clase que está implementando a la interface UserDetailsService

    @Autowired
    private JwtService jwtService;

    //El LoginRequest es un DTO de Persona
    @Override
    public String login(LoginRequest request) {
        System.out.println("El correo es: " + request.getCorreo());
        System.out.println("La contraseña es: " + request.getPassword());

        //El uso del "orElseThrow", hace que se rompa el optional y se trabaje con la clase directa, sin tener que usar el Optional<Persona>
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