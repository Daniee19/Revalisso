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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String celular;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Contribucion> contribuciones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Blog> blogs;
}
