package com.revalisso.backend.config;

import com.revalisso.backend.service.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/usuario/**").hasAnyRole("USUARIO", "ADMIN")
                        .anyRequest().authenticated()
                )
                /**
                 * Va a recibir en jwtAuthenticationFilter el "headers" dado desde el fetch del frontend (manéjalo con
                 * localStorage => headers: { "Authorization": "Bearer " + localStorage.getItem("token") }
                 -----------------------------------------------
                 * El jwtAuthenticationFilter -> solo valída el JWT y pone al usuario autenticado en el contexto de
                 * Spring.
                 * Por cierto, no se está trabajando con la lógica de formularios y sesiones, por ende,
                 * "UsernamePasswordAuthenticationFilter" no se va a llamar nunca, pero es necesario para completar el
                 * parámetro, además que si se trabajase con ello sería obligatorio crear un archivo que implemente de
                 * la interface UserDetailsService para buscar la clase persona y que retorne un
                 * CustomUserDetails(persona).
                 */
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
