package com.revalisso.backend.controller;

import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.service.IPersonaService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getPersona(@RequestHeader("Authorization") String authHeader) {
        //Obtener token
        String token = authHeader.replace("Bearer ", ""); // quitar el prefijo
        String username = extractCorreo(token);
        System.out.println("El token es: " + token);
        System.out.println("El correo es: " + username);

        PersonaDTO personaDTO = personaService.getPersonaDTObyCorreo(username);

        Map<String, Object> persona = new HashMap<>();
        persona.put("nombre", personaDTO.getNombre());
        persona.put("apellido", personaDTO.getApellido());
        persona.put("celular", personaDTO.getCelular());
        persona.put("rol", personaDTO.getRol().getNombreRol());
        persona.put("correo", personaDTO.getCorreo());
        persona.put("donaciones", personaDTO.getContribuciones().stream().map(d -> d.getTituloContribucion()).toList());
        persona.put("blogs", personaDTO.getBlogs().stream().map(b -> b.getDescripcionBlog()).toList());

//        ResponseEntity.ok("Token recibido: " + token);
        return ResponseEntity.ok(persona);
//        return personaService.getPersona(personaService.getPersonaDTO());
    }

    public String extractCorreo(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // 👈 aquí recuperas el subject (el correo)
    }
}
