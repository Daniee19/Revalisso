package com.revalisso.backend.service;

import com.revalisso.backend.dto.CategoriaDTO;
import com.revalisso.backend.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<CategoriaDTO> getCategorias();
    public Categoria getCategoriaById(Long idCategoria);
}
