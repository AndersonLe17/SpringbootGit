package com.djl.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String rol;
    private String password;
    private String estado;
    private Date fechaNacimiento;
    private String celular;
    private String direccion;
    private String pais;
}
