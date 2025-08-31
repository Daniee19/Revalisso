package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Archivo;
import com.revalisso.backend.entity.Blog;
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
    private String tituloBlog;
    private String descripcionBlog;
    private PersonaDTO persona;
    private String urlBlog;
    private String fotoBlog;

    public BlogDTO(Blog blog) {
        this.tituloBlog = blog.getTituloBlog();
        this.descripcionBlog = blog.getDescripcionBlog();
        this.persona = new PersonaDTO(blog.getPersona());
        this.urlBlog = blog.getUrlBlog();
        this.fotoBlog = blog.getFotoBlog();
    }
}
