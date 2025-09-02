package com.revalisso.backend.repository;

import com.revalisso.backend.entity.HistorialPunto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPuntoRepository extends CrudRepository<HistorialPunto, Long> {
}
