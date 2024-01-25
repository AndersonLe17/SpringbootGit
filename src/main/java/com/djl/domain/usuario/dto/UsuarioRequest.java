package com.djl.domain.usuario.dto;

import com.djl.domain.enums.EstadoUsuario;
import com.djl.domain.enums.Rol;
import com.djl.domain.enums.TipoDocumento;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioRequest {

    private TipoDocumento tipoDocumento;
    @Size(min = 8, max = 15)
    private String numDocumento;
    @Size(min = 3, max = 100)
    private String nombre;
    @Size(min = 3, max = 100)
    private String apellido;
    @Size(min = 3, max = 100)
    private String username;
    @Email
    private String email;
    private Rol rol;
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]+$", message = "La contraseña debe contener al menos una letra y un número")
    private String password;
    private EstadoUsuario estado;
    @Past(message = "La fecha debe estar en pasado")
    private Date fechaNacimiento;
    @Pattern(regexp = "^[0-9]+$", message = "El número de celular debe contener solo dígitos")
    private String celular;
}
