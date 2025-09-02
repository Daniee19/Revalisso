package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.CategoriaDTO;
import com.revalisso.backend.entity.Categoria;
import com.revalisso.backend.repository.CategoriaRepository;
import com.revalisso.backend.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> getCategorias() {
        List<CategoriaDTO> lista = new ArrayList<>();
        categoriaRepository.findAll().forEach(c -> {
            lista.add(new CategoriaDTO(c));
        });
        return lista;
    }

    //Lo pongo como entidad por facilidad más que nada
    @Override
    public Categoria getCategoriaById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElseThrow(() -> new RuntimeException("Categoria no encontrada (error en categoriaServiceImpl)"));
    }
}
