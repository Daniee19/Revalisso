package com.revalisso.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;
    private String nombreEstado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado", cascade = CascadeType.ALL)
    List<Contribucion> contribuciones;

}
