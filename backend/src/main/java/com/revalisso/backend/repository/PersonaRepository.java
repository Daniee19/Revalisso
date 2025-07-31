package com.revalisso.backend.repository;

import com.revalisso.backend.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    Optional<Persona> findByCorreo(String correo);
}
