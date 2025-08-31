package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.dto.EstadoDTO;
import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.entity.Contribucion;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.ContribucionRepository;
import com.revalisso.backend.service.IContribucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContribucionServiceImpl implements IContribucionService {

    @Autowired
    ContribucionRepository cr;
    @Autowired
    private ContribucionRepository contribucionRepository;

    @Override
    public ContribucionDTO getContribucion(int id) {
        return null;
    }

    @Override
    public List<ContribucionDTO> getAllContribucion() {
        List<ContribucionDTO> lista = new ArrayList<ContribucionDTO>();
        /**
         * Se obtiene el resultado de la entidad traída del crud repository, lo convierto a dtp, pero dentro como un elemento de una lista para retornar ese valor de una lista con DTOs
         */
        cr.findAll().forEach(contribucion -> lista.add(new ContribucionDTO(contribucion)));
        return lista;
    }
//        contribucion -> {
//                    ContribucionDTO cdto = ContribucionDTO.builder().
//                            cantidadAproximada(contribucion.getCantidadAproximada()).
//                            tituloContribucion(contribucion.getTituloContribucion()).
//                            descripcionContribucion(contribucion.getDescripcionContribucion()).
//                            fechaContribucion(contribucion.getFechaContribucion()).
//                            estado(EstadoDTO.builder().nombreEstado(contribucion.getEstado().
//                                    getNombreEstado()).build()).
//                            persona(PersonaDTO.builder()
//                                    .nombre(contribucion.getPersona().getNombre())
//                                    .apellido(contribucion.getPersona().getApellido())
//                                    .correo(contribucion.getPersona().getCorreo())
//                                    .build()).
//                            build();


    @Override
    public List<ContribucionDTO> getContribucionByIdUsuario(Long idUsuario) {
        return contribucionRepository.findByIdUsuario(idUsuario).stream().map(
                contribucion -> new ContribucionDTO(contribucion)).collect(Collectors.toList());
    }
}
