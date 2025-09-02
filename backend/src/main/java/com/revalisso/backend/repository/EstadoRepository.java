package com.revalisso.backend.repository;

import com.revalisso.backend.entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
