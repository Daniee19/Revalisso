package com.revalisso.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HistorialPunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialPunto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Donacion donacion;

    private String motivo;
    private int cantidadPuntos;
}
