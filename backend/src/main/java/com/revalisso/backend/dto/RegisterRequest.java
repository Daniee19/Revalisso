package com.revalisso.backend.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest  implements java.io.Serializable {
    private String nombres;
    private String apellidos;
    private String celular;
    private String correo;
    private String password;
    private Long rol;
}
