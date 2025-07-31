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
public class RolDTO implements Serializable {
    private List<PersonaDTO> listaPersonas;
    private String nombreRol;
}
