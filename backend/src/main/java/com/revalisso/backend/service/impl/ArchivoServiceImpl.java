package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.ArchivoDTO;
import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.entity.Archivo;
import com.revalisso.backend.entity.Contribucion;
import com.revalisso.backend.repository.ArchivoRepository;
import com.revalisso.backend.repository.ContribucionRepository;
import com.revalisso.backend.service.IArchivoService;
import com.revalisso.backend.service.IContribucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    ArchivoRepository archivoRepository;
    //El Archivo va a depender del Contribuidor (Borrar contribucionService)
    @Autowired
    ContribucionRepository contribucionRepository;

    @Override
    public ArchivoDTO agregarArchivo(ArchivoDTO archivoDTO) {

        Archivo archivo = Archivo.builder()
                .rutaArchivo(archivoDTO.getRutaArchivo())
                .contribucion(contribucionRepository.findById(archivoDTO.getIdContribucion()).orElseThrow(() -> new RuntimeException("No se encontro el id contribucion")))
                .build();

        Archivo saved = archivoRepository.save(archivo);

        //Se usa el saved porque ahí podré obtener el id generado desde la base de datos
        return new ArchivoDTO(saved);
    }

    @Override
    public List<Archivo> findArchivoByIdContribucion(Long idContribucion) {
        return archivoRepository.findArchivoByIdContribucion(idContribucion);
    }
}
