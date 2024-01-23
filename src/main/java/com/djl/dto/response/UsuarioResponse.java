package com.djl.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String rol;
    private String estado;
    private Date fechaNacimiento;
    private String celular;
    private String direccion;
    private String pais;
}
