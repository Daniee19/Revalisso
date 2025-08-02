package com.revalisso.backend.service;

import com.revalisso.backend.entity.Persona;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Esta clase @CustomUserDetails por medio de la interface @UserDetails permite identificar
 * qué usuario se ha autenticado y qué rol o permisos tiene ese usuario.
 */

/**
 * TOP:
 * Es importante la clase CustomUserDetails, aunque no se llame explícitamente. Si no que se llame por medio del
 * método desde la clase que se llama CustomerUserDetailsService que implementa la interface UserDetailsService.
 */
public class CustomUserDetails implements UserDetails {

    private final Persona persona;

    public CustomUserDetails(Persona persona) {
        this.persona = persona;
    }

    /**
     * new SimpleGrantedAuthority(...) → Crea una autoridad (permiso) para ese rol. Spring la reconoce.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + persona.getRol().getNombreRol()));
    }

    @Override
    public String getPassword() {
        return persona.getPassword();
    }

    @Override
    public String getUsername() {
        return persona.getCorreo();
    }

    public Persona getPersona() {
        return this.persona;
    }
}
