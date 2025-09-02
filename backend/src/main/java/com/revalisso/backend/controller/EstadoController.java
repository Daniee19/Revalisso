package com.revalisso.backend.controller;

import com.revalisso.backend.repository.EstadoRepository;
import com.revalisso.backend.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class EstadoController {

    @Autowired
    private IEstadoService estadoService;

    @GetMapping("/estados")
    public ResponseEntity<?> getAllEstados() {
        return ResponseEntity.ok(estadoService.getAllEstados());
    }

}
