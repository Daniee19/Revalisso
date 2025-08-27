package com.revalisso.backend.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReseniaContribucionDTO implements Serializable {

    private ContribucionDTO contribucion;
    private String comentario;
    private Integer calificacion;
    private Timestamp fechaResenia;
}
