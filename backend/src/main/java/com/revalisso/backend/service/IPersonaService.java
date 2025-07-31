package com.revalisso.backend.service;

import com.revalisso.backend.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {
    public Persona getPersona(int id);
    public List<Persona> getAllPersonas();
    public boolean addPersona(Persona persona);
    public boolean updatePersona(Persona persona);
    public boolean deletePersona(int id);
}
