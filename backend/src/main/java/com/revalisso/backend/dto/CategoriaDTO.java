package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Categoria;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDTO implements Serializable {
    private Long idCategoria;
    //Esto se estará enviando como clave. En angular poner en interface ese nombre.
    private String nombreCategoria;
//    private List<ContribucionDTO> contribuciones;

    public CategoriaDTO(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.nombreCategoria = categoria.getNombreCategoria();
    }
}