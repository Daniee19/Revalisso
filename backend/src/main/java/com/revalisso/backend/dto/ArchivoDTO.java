package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Archivo;
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
//    private BlogDTO blog; //Este es la variable "blog" que se mapea desde la otra clase (Blog)

    private ContribucionDTO contribucion;

    public ArchivoDTO(Archivo archivo) {
        this.rutaArchivo = archivo.getRutaArchivo();
        this.tipoArchivo = archivo.getTipoArchivo();
        this.contribucion = new ContribucionDTO(archivo.getContribucion());
    }
}
