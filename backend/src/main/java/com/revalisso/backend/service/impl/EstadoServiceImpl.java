package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.EstadoDTO;
import com.revalisso.backend.entity.Estado;
import com.revalisso.backend.repository.EstadoRepository;
import com.revalisso.backend.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public Estado getEstadoById(Long idEstado) {
        System.out.println("El id del estado es: " + idEstado);
        return estadoRepository.findById(idEstado).get();
    }

    @Override
    public List<EstadoDTO> getAllEstados() {
        List<EstadoDTO> lista = new ArrayList<>();
        estadoRepository.findAll().forEach(e -> {
            lista.add(new EstadoDTO(e));
        });
        return lista;
    }
}
