package com.revalisso.backend.entity;

import com.revalisso.backend.dto.ContribucionDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    private List<ReseniaContribucion> reseniasContribucion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contribucion", cascade = CascadeType.ALL)
    private List<Archivo> archivos = new ArrayList<>();

    private int cantidadAproximada;
    private String tituloContribucion;

    @CreationTimestamp
    private LocalDate fechaContribucion;
    private String descripcionContribucion;

}
