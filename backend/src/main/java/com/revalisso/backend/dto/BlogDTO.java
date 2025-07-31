package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Archivo;
import com.revalisso.backend.entity.Persona;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDTO implements Serializable {
    private String descripcionBlog;
    private PersonaDTO persona;

    private List<ArchivoDTO> listaArchivo;
}
