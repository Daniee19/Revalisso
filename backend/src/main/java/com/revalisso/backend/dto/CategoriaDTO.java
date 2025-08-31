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
    private String nombreCategoria;
//    private List<ContribucionDTO> contribuciones;

    public CategoriaDTO(Categoria categoria) {
        this.nombreCategoria = categoria.getNombreCategoria();
    }
}