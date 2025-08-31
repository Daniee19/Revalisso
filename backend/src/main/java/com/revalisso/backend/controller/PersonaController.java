package com.revalisso.backend.controller;

import com.revalisso.backend.dto.BlogDTO;
import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.service.IBlogService;
import com.revalisso.backend.service.IContribucionService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @Autowired
    IContribucionService contribucionService;

    @Autowired
    IBlogService blogService;


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
        List<ContribucionDTO> contribucionDTO = contribucionService.getContribucionByIdUsuario(personaDTO.getId());

        //Hacer la sección de blogs
        List<BlogDTO> blogDTO = blogService.getBlogByIdUsuario(personaDTO.getId());

        Map<String, Object> persona = new HashMap<>();
        persona.put("nombre", personaDTO.getNombre());
        persona.put("apellido", personaDTO.getApellido());
        persona.put("celular", personaDTO.getCelular());
        persona.put("rol", personaDTO.getRol());
        persona.put("correo", personaDTO.getCorreo());
        persona.put("contribuciones", contribucionDTO);
        persona.put("blogs", blogDTO);

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
