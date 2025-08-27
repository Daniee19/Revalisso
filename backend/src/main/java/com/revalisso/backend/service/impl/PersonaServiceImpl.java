package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.*;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.PersonaRepository;
import com.revalisso.backend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona getPersona(int id) {
        return null;
    }

    @Override
    public List<Persona> getAllPersonas() {
        return List.of();
    }

    @Override
    public boolean addPersona(Persona persona) {
        return false;
    }

    @Override
    public boolean updatePersona(Persona persona) {
        return false;
    }

    @Override
    public boolean deletePersona(int id) {
        return false;
    }

    /**
     * Lo que hacemos es con el map vamos a convertir de Optional<Persona> a PersonaDTO
     */
    @Override
    public PersonaDTO getPersonaDTObyCorreo(String correo) {
        return personaRepository.findByCorreo(correo)
                .map(p -> PersonaDTO.builder()
                        .rol(RolDTO.builder()
                                .nombreRol(p.getRol().getNombreRol())
                                .listaPersonas(p.getRol().getListaPersonas()
                                        .stream().map(per -> PersonaDTO.builder()
                                                .nombre(per.getNombre())
                                                .apellido(per.getApellido())
                                                .celular(per.getCelular())
                                                .build()).toList())
                                .build())
                        .nombre(p.getNombre())
                        .apellido(p.getApellido())
                        .correo(p.getCorreo())
                        .contribuciones(p.getContribuciones().stream().map(contri -> ContribucionDTO.builder()
                                .tituloContribucion(contri.getTituloContribucion())
                                .descripcionContribucion(contri.getDescripcionContribucion())
                                .estado(EstadoDTO.builder().nombreEstado(contri.getEstado().getNombreEstado()).build())
                                .categoria(CategoriaDTO.builder().nombreCategoria(contri.getCategoria().getNombreCategoria()).build())
                                .persona(PersonaDTO.builder().nombre(contri.getPersona().getNombre()).build())
                                .historialPuntos(contri.getHistorialPuntos().stream().map(hp -> HistorialPuntoDTO.builder()
                                        .motivo(hp.getMotivo())
                                        .cantidadPuntos(hp.getCantidadPuntos())
                                        .build()).toList())
                                .archivos(contri.getArchivos().stream().map(archi -> ArchivoDTO.builder()
                                        .rutaArchivo(archi.getRutaArchivo())
                                        .tipoArchivo(archi.getTipoArchivo())
                                        .blog(BlogDTO.builder()
                                                .descripcionBlog(archi.getBlog().getDescripcionBlog()).build())
                                        .build()).toList())
                                .reseniasContribucion(contri.getReseniasContribucion().stream().map(rese ->
                                        ReseniaContribucionDTO.builder()
                                                .calificacion(rese.getCalificacion())
                                                .comentario(rese.getComentario())
                                                .fechaResenia(rese.getFechaResenia())
                                                .build()).toList())
                                .cantidadAproximada(contri.getCantidadAproximada())
                                .fechaContribucion(contri.getFechaContribucion())
                                .build()).toList())
                        .celular(p.getCelular())
                        .blogs(p.getBlogs().stream().map(b -> BlogDTO.builder()
                                .descripcionBlog(b.getDescripcionBlog())
                                .build()).toList())
                        .build()).orElse(null);
    }
}
