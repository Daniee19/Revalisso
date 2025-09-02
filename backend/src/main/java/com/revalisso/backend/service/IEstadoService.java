package com.revalisso.backend.service;

import com.revalisso.backend.dto.EstadoDTO;
import com.revalisso.backend.entity.Estado;

import java.util.List;

public interface IEstadoService {
    public Estado getEstadoById(Long id_estado);

    public List<EstadoDTO> getAllEstados();
}
