package com.revalisso.backend.service;

import com.revalisso.backend.dto.HistorialPuntoDTO;
import com.revalisso.backend.entity.HistorialPunto;

import java.util.List;

public interface IHistorialPuntoService {
    public List<HistorialPuntoDTO> getHistorialPuntos(Long idHistorialPunto);
}
