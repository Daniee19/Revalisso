package com.revalisso.backend.repository;

import com.revalisso.backend.entity.Contribucion;
import com.revalisso.backend.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContribucionRepository extends CrudRepository<Contribucion, Long> {
    @Query("SELECT c FROM Contribucion c WHERE c.persona.idPersona = :id_usuario")
    List<Contribucion> findByIdUsuario(Long id_usuario);
    //Hacer la consulta para traer la contribucion poor id de usuario
}