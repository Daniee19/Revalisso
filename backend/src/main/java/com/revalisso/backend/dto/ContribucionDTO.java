package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Contribucion;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContribucionDTO implements Serializable {
    //    private PersonaDTO persona;
    private EstadoDTO estado;
    private CategoriaDTO categoria;

    //    private List<HistorialPuntoDTO> historialPuntos;
    private List<ArchivoDTO> archivos;
    //    private List<ReseniaContribucionDTO> reseniasContribucion;
    private Timestamp fechaContribucion;
    private int cantidadAproximada;
    private String tituloContribucion;
    private String descripcionContribucion;

    public ContribucionDTO(Contribucion contribucion) {
        //Se está asignando el valor dado desde el service, con finalidad de que las entidades tengan todos los valores
        this.estado = new EstadoDTO(contribucion.getEstado().getNombreEstado());
        this.categoria = new CategoriaDTO(contribucion.getCategoria());
        this.cantidadAproximada = contribucion.getCantidadAproximada();
        this.tituloContribucion = contribucion.getTituloContribucion();
        this.descripcionContribucion = contribucion.getDescripcionContribucion();
        this.fechaContribucion = contribucion.getFechaContribucion();
        //Esencial para cambiar la entidad Archivo a ArchivoDTO
//        this.archivos = contribucion.getArchivos().stream().map(ArchivoDTO::new).toList(); //-> lo que hace es pasar como parámetro la entidad Archivo en el constructor del DTO ArchivoDTO.
    }
}
