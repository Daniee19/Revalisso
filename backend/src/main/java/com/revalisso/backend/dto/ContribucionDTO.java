package com.revalisso.backend.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContribucionDTO implements Serializable {
    private PersonaDTO persona;
    private EstadoDTO estado;
    private CategoriaDTO categoria;

    private List<HistorialPuntoDTO> historialPuntos;
    private List<ArchivoDTO> archivos;
    private List<ReseniaContribucionDTO> reseniasContribucion;
    private Timestamp fechaContribucion;
    private int cantidadAproximada;
    private String tituloContribucion;

    private String descripcionContribucion;
}
