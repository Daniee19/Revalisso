package com.revalisso.backend.service.impl;

import com.revalisso.backend.entity.Persona;
import com.revalisso.backend.service.IPersonaService;

import java.util.List;

public class PersonaServiceImpl implements IPersonaService{
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
}
