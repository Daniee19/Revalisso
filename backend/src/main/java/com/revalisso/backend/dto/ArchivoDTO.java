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
    private Long idArchivo;
    private String rutaArchivo;
//    private BlogDTO blog; //Este es la variable "blog" que se mapea desde la otra clase (Blog)

    private Long idContribucion;

    public ArchivoDTO(Archivo archivo) {
        System.out.println("Estoy en el constructor del ArchivoDTO: " + archivo);
        this.idArchivo = archivo.getIdArchivo();
        this.rutaArchivo = archivo.getRutaArchivo();

        if (archivo.getContribucion().getIdContribucion() != null) {
            this.idContribucion = archivo.getContribucion().getIdContribucion();
        }
    }
}
