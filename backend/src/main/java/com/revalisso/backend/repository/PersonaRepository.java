package com.revalisso.backend.repository;

import com.revalisso.backend.dto.PersonaDTO;
import com.revalisso.backend.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    @Query("SELECT p FROM Persona p JOIN FETCH p.rol WHERE p.correo = :correo")
    Optional<Persona> findByCorreo(String correo);
}
