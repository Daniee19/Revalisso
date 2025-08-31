package com.revalisso.backend.dto;

import com.revalisso.backend.entity.Persona;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDTO implements Serializable {
    private Long id;
    private String rol;
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;
//    private List<ContribucionDTO> contribuciones;
//    private List<BlogDTO> blogs;

    public PersonaDTO(Persona p) {
        this.id = p.getIdPersona();
        this.rol = p.getRol().getNombreRol();
        this.nombre = p.getNombre();
        this.apellido = p.getApellido();
        this.celular = p.getCelular();
        this.correo = p.getCorreo();
        // aquí decides si incluyes las contribuciones o no
        //Me retorna los campos de la entidad Contribuciones
//        this.contribuciones = p.getContribuciones()
//                .stream()
//                .map(ContribucionDTO::new)
//                .toList();
    }

}
