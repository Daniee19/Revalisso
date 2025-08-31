package com.revalisso.backend.controller;

import com.revalisso.backend.service.IContribucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contributions")
public class ContribucionesController {

    @Autowired
    IContribucionService contribucionService;

    @GetMapping
    public ResponseEntity<?> getContribuciones() {
        return ResponseEntity.ok(contribucionService.getAllContribucion());
    }
}
