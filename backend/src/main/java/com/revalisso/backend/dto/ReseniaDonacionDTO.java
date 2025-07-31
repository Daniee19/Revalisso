package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Donacion;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReseniaDonacionDTO implements Serializable {

    private DonacionDTO donacion;
    private String comentario;
    private Integer calificacion;
    private Timestamp fechaResenia;
}
