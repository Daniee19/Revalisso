package com.revalisso.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReseniaContribucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contribucion")
    private Contribucion contribucion;

    private String comentario;
    private Integer calificacion;
    private Timestamp fechaResenia;
}
