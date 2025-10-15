package com.revalisso.backend.repository;

import com.revalisso.backend.entity.Archivo;
import com.revalisso.backend.entity.Contribucion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivoRepository extends CrudRepository<Archivo, Long> {
    @Query("SELECT a FROM Archivo a WHERE a.contribucion.idContribucion = :id_contribucion")
    List<Archivo> findArchivoByIdContribucion(Long id_contribucion);
}
