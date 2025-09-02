package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.ContribucionDTO;
import com.revalisso.backend.dto.EstadoDTO;
import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.entity.Contribucion;
import com.revalisso.backend.entity.Estado;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.ContribucionRepository;
import com.revalisso.backend.service.ICategoriaService;
import com.revalisso.backend.service.IContribucionService;
import com.revalisso.backend.service.IEstadoService;
import com.revalisso.backend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContribucionServiceImpl implements IContribucionService {

    @Autowired
    private ContribucionRepository contribucionRepository;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private ICategoriaService categoriaService;

    @Override
    public ContribucionDTO getContribucion(Long id) {
        return null;
    }

    @Autowired
    private IEstadoService estadoService;


    @Override
    public List<ContribucionDTO> getAllContribucion() {
        List<ContribucionDTO> lista = new ArrayList<ContribucionDTO>();
        /**
         * Se obtiene el resultado de la entidad traída del crud repository, lo convierto a dtp, pero dentro como un elemento de una lista para retornar ese valor de una lista con DTOs
         */
        contribucionRepository.findAll().forEach(contribucion -> {
            System.out.println("Contribución: " + contribucion.getTituloContribucion() +
                    " | Categoria: " + (contribucion.getCategoria() != null ? contribucion.getCategoria().getIdCategoria() : "NULL"));
            lista.add(new ContribucionDTO(contribucion));
        });
        return lista;
    }

    @Override
    public List<ContribucionDTO> getContribucionByIdUsuario(Long idUsuario) {
        System.out.println("El id del usuario es (getContribucionByIdUsuario): " + idUsuario);

        return contribucionRepository.findByIdUsuario(idUsuario).stream().map(
                contribucion -> new ContribucionDTO(contribucion)).collect(Collectors.toList());
    }

    @Override
    public ContribucionDTO addContribucion(ContribucionDTO contribucionDTO) {
        /**
         * Se obtuvo el DTO como parámetro, luego se adaptó a una entidad para poder guardar ese resultado en la base
         * de datos. Y al final se retorna el registro subido a la base de datos pero ajustado a DTO.
         */
        Contribucion contribucion = Contribucion.builder()
                .tituloContribucion(contribucionDTO.getTituloContribucion())
                .descripcionContribucion(contribucionDTO.getDescripcionContribucion())
                .fechaContribucion(contribucionDTO.getFechaContribucion())
                .estado(estadoService.getEstadoById(contribucionDTO.getEstado().getIdEstado()))
                .persona(personaService.getPersona(contribucionDTO.getPersona().getId()))
                .categoria(categoriaService.getCategoriaById(contribucionDTO.getCategoria().getIdCategoria()))
                .build();
        Contribucion saved = contribucionRepository.save(contribucion);

        //Se usa el saved porque ahí podré obtener el id generado desde la base de datos
        return new ContribucionDTO(saved);
    }
}
