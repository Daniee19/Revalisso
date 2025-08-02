package com.revalisso.backend.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordRequest {
    private String correo;
    private String oldPassword;
    private String newPassword;
}
