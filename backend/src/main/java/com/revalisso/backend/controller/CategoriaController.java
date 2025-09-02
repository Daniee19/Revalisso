package com.revalisso.backend.controller;

import com.revalisso.backend.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CategoriaController {

    @Autowired
    ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<?> obtenerCategorias() {
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

}
