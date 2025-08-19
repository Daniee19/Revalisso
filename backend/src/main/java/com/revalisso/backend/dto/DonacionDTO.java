package com.revalisso.backend.dto;

import com.revalisso.backend.entity.*;
import jakarta.persistence.*;
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
public class DonacionDTO implements Serializable {
    private PersonaDTO persona;
    private EstadoDTO estado;
    private CategoriaDTO categoria;

    private List<HistorialPuntoDTO> historialPuntos;
    private List<ArchivoDTO> archivos;
    private List<ReseniaDonacionDTO> reseniasDonacion;
    private Timestamp fechaDonacion;
    private int cantidadAproximada;
    private String tituloDonacion;

    private String descripcionDonacion;
}
