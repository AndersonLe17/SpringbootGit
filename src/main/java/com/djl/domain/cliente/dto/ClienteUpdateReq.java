package com.djl.domain.cliente.dto;

import com.djl.domain.direccion.dto.DireccionUpdateReq;
import com.djl.domain.enums.TipoDocumento;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ClienteUpdateReq {
    @Size(min = 3, max = 100, message = "El nombre debe tener mas de 3 caracteres")
    private String nombre;

    @Size(min = 3, max = 100, message = "El apellido debe tener mas de 3 caracteres")
    private String apellido;

    private TipoDocumento tipoDocumento;

    @Size(min = 8, max = 15, message = "El numero de documento debe tener entre 8 y 15 caracteres")
    private String numDocumento;

    @Size(min = 3, max = 255, message = "El email debe tener mas de 3 caracteres")
    @Email(message = "El email no es valido")
    private String email;

    @Size(min = 9, max = 9, message = "El celular debe tener 9 caracteres")
    @Pattern(regexp = "[0-9]{9}", message = "El celular debe tener solo numeros")
    private String celular;

    private DireccionUpdateReq direccion;
}
