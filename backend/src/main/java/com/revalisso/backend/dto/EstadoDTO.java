package com.revalisso.backend.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDTO implements Serializable {

    private String nombreEstado;
    List<ContribucionDTO> contribuciones;

}
