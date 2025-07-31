package com.revalisso.backend.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest  implements java.io.Serializable {
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;
    private String password;
}
