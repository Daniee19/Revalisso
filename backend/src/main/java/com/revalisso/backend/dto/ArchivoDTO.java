package com.revalisso.backend.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArchivoDTO implements Serializable {
    private String rutaArchivo;
    private String tipoArchivo;
    private BlogDTO blog; //Este es la variable "blog" que se mapea desde la otra clase (Blog)

    private DonacionDTO donacion;
}
