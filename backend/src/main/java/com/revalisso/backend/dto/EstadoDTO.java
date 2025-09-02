package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Estado;
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
    private Long idEstado;
    private String nombreEstado;
//    List<ContribucionDTO> contribuciones;

    public EstadoDTO(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public EstadoDTO(Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.nombreEstado = estado.getNombreEstado();
    }
}
