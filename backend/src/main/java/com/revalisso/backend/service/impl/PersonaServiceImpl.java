package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.*;
import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.repository.PersonaRepository;
import com.revalisso.backend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona getPersona(int id) {
        return null;
    }

    @Override
    public List<Persona> getAllPersonas() {
        return List.of();
    }

    @Override
    public boolean addPersona(Persona persona) {
        return false;
    }

    @Override
    public boolean updatePersona(Persona persona) {
        return false;
    }

    @Override
    public boolean deletePersona(int id) {
        return false;
    }

    /**
     * Lo que hacemos es con el map vamos a convertir de Optional<Persona> a PersonaDTO
     */
    @Override
    public PersonaDTO getPersonaDTObyCorreo(String correo) {
        return personaRepository.findByCorreo(correo)
                .map(PersonaDTO::new).orElse(null);
    }
}
