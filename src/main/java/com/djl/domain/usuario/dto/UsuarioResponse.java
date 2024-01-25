package com.djl.domain.usuario.dto;

import com.djl.domain.enums.EstadoUsuario;
import com.djl.domain.enums.Rol;
import com.djl.domain.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private TipoDocumento tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private Rol rol;
    private EstadoUsuario estado;
    private Date fechaNacimiento;
    private String celular;
}
