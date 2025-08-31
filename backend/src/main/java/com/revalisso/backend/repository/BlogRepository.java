package com.revalisso.backend.repository;

import com.revalisso.backend.entity.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    @Query("SELECT b from Blog b where b.persona.idPersona = :id_persona")
    List<Blog> findBlogsByIdUsuario(Long id_persona);
}
