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
public class CategoriaDTO implements Serializable {
    private String nombreCategoria;
    private List<ContribucionDTO> donaciones;

}
