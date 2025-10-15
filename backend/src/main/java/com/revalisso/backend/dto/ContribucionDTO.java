package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Contribucion;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContribucionDTO implements Serializable {
    private Long idContribucion;
    private PersonaDTO persona;
    private Long idEstado;
    private CategoriaDTO categoria;

    //    private List<HistorialPuntoDTO> historialPuntos;
    //Va a ser útil para mostrar en frontend. (La relación ya está en Entity)
    private List<ArchivoDTO> archivos;
    //    private List<ReseniaContribucionDTO> reseniasContribucion;
    private LocalDate fechaContribucion;
    private int cantidadAproximada;
    private String tituloContribucion;
    private String descripcionContribucion;

    public ContribucionDTO(Contribucion contribucion) {
        System.out.println("Estoy en ContribucionDTO, y la contribucion es: " + contribucion.getIdContribucion());
        //Se está asignando el valor dado desde el service, con finalidad de que las entidades tengan todos los valores
        this.idContribucion = contribucion.getIdContribucion();
        this.idEstado = contribucion.getEstado().getIdEstado();
//        this.estado = new EstadoDTO(contribucion.getEstado());
        this.categoria = new CategoriaDTO(contribucion.getCategoria());
        this.persona = new PersonaDTO(contribucion.getPersona());
        this.cantidadAproximada = contribucion.getCantidadAproximada();
        this.tituloContribucion = contribucion.getTituloContribucion();
        this.descripcionContribucion = contribucion.getDescripcionContribucion();
        this.fechaContribucion = contribucion.getFechaContribucion();
        if (contribucion.getArchivos() != null) {
            this.archivos = contribucion.getArchivos().stream().map(ArchivoDTO::new).collect(Collectors.toList());
        } else { //me da error por el id que no se encuentra y si se encuentra da bucle por las entity 
            this.archivos = new ArrayList<>();
        }
    }
}
//Esencial para cambiar la entidad Archivo a ArchivoDTO
//        this.archivos = contribucion.getArchivos().stream().map(ArchivoDTO::new).toList(); //-> lo que hace es pasar como parámetro la entidad Archivo en el constructor del DTO ArchivoDTO.

