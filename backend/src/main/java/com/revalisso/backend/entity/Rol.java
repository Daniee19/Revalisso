package com.revalisso.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Persona> listaPersonas;

    @Column(name = "nombre_rol")
    private String nombreRol;
}
