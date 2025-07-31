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
public class PersonaDTO implements Serializable {
    private RolDTO rol;
    private String nombre;
    private String apellido;
    private String celular;
    private List<DonacionDTO> donaciones;
    private List<BlogDTO> blogs;
}
