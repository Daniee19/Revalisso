package com.revalisso.backend.dto;

import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialPuntoDTO implements Serializable {
    private DonacionDTO donacion;

    private String motivo;
    private int cantidadPuntos;
}
