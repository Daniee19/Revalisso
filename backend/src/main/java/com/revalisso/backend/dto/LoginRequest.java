package com.revalisso.backend.dto;

import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest implements Serializable {
    private String correo;
    private String password;
}
