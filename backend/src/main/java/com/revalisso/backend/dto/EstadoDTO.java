package com.revalisso.backend.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class EstadoDTO implements Serializable {

    private String nombreEstado;
//    List<ContribucionDTO> contribuciones;

    public EstadoDTO(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
