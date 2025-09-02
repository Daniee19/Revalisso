package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.HistorialPuntoDTO;
import com.revalisso.backend.entity.HistorialPunto;
import com.revalisso.backend.repository.HistorialPuntoRepository;
import com.revalisso.backend.service.IHistorialPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPuntoServiceImpl implements IHistorialPuntoService {

    @Autowired
    HistorialPuntoRepository historialPuntoRepository;

    @Override
    public List<HistorialPuntoDTO> getHistorialPuntos(Long idHistorialPunto) {
        System.out.println("El id de historial punto es: "+idHistorialPunto);
        return historialPuntoRepository.findById(idHistorialPunto).stream().map(HistorialPuntoDTO::new).toList();
    }
}
