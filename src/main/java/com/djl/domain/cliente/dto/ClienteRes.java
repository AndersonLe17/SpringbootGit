package com.djl.domain.cliente.dto;

import com.djl.domain.direccion.dto.DireccionRes;
import com.djl.domain.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ClienteRes {
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String numDocumento;
    private String email;
    private String celular;
    private DireccionRes direccion;
}
