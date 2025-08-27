package com.revalisso.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contribucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContribucion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contribucion", cascade = CascadeType.ALL)
    private List<HistorialPunto> historialPuntos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contribucion", cascade = CascadeType.ALL)
    private List<Archivo> archivos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contribucion", cascade = CascadeType.ALL)
    private List<ReseniaContribucion> reseniasContribucion;

    private int cantidadAproximada;
    private String tituloContribucion;
    private Timestamp fechaContribucion;
    private String descripcionContribucion;

}
