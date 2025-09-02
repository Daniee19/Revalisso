package com.revalisso.backend.controller;

import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.entity.Contribucion;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.service.IContribucionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContribucionesController {

    @Autowired
    IContribucionService contribucionService;

    @GetMapping("/contribuciones")
    public ResponseEntity<?> getContribuciones() {
        return ResponseEntity.ok(contribucionService.getAllContribucion());
    }

    @PostMapping("/contribuciones")
    public ResponseEntity<?> addContribucion(@RequestBody ContribucionDTO contribucionDTO) {
        System.out.println(contribucionDTO);
        return ResponseEntity.ok(contribucionService.addContribucion(contribucionDTO));
    }
    //Enviar información de la persona desde el front? o un id desde el backend
}
