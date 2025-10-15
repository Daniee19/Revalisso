package com.revalisso.backend.service;

import com.revalisso.backend.dto.ArchivoDTO;
import com.revalisso.backend.entity.Archivo;

import java.util.List;

public interface IArchivoService {
    public ArchivoDTO agregarArchivo(ArchivoDTO archivoDTO);
    public List<Archivo> findArchivoByIdContribucion(Long idContribucion);
}
