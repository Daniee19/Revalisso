package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.LoginRequest;
import com.revalisso.backend.dto.RegisterRequest;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.PersonaRepository;
import com.revalisso.backend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    //El LoginRequest es un DTO de Persona
    @Override
    public String login(LoginRequest request) {
        System.out.println("El correo es: "+request.getCorreo());
        //El uso del "orElseThrow", hace que se rompa el optional y se trabaje con la clase directo, sin tener que usar el Optional<Persona>
        Persona persona = personaRepository.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Correo no registrado"));

        //Se compara la contraseña ingresada (texto plano), con la contraseña hasheada de la base de datos
        if (!passwordEncoder.matches(request.getPassword(), persona.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return "Login exitoso";
    }
}