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
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArchivo;
    private String rutaArchivo;
    private String tipoArchivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_blog") //Es el nombre de la columna de la llave foránea en la clase Archivo
    private Blog blog; //Este es la variable "blog" que se mapea desde la otra clase (Blog)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contribucion")
    private Contribucion contribucion;
}
