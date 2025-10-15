package com.revalisso.backend.service;

import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.entity.Contribucion;

import java.util.List;

public interface IContribucionService {
    public Contribucion getContribucion(Long id);

    public List<ContribucionDTO> getAllContribucion();

    public List<ContribucionDTO> getContribucionByIdUsuario(Long idUsuario);

    public ContribucionDTO addContribucion(ContribucionDTO contribucionDTO);
}
