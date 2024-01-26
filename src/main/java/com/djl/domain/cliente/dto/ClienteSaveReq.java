package com.djl.domain.cliente.dto;

import com.djl.domain.direccion.dto.DireccionSaveReq;
import com.djl.domain.enums.TipoDocumento;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ClienteSaveReq {
    @Size(min = 3, max = 100, message = "El nombre debe tener mas de 3 caracteres")
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @Size(min = 3, max = 100, message = "El apellido debe tener mas de 3 caracteres")
    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;

    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;

    @Size(min = 8, max = 15, message = "El numero de documento debe tener entre 8 y 15 caracteres")
    @NotNull(message = "El numero de documento no puede ser nulo")
    @NotBlank(message = "El numero de documento no puede estar en blanco")
    private String numDocumento;

    @Size(min = 3, max = 255, message = "El email debe tener mas de 3 caracteres")
    @Email(message = "El email no es valido")
    @NotNull(message = "El email no puede ser nulo")
    private String email;

    @Size(min = 9, max = 9, message = "El celular debe tener 9 caracteres")
    @NotNull(message = "El celular no puede ser nulo")
    @NotBlank(message = "El celular no puede estar en blanco")
    @Pattern(regexp = "[0-9]{9}", message = "El celular debe tener solo numeros")
    private String celular;

    @NotNull(message = "La direccion no puede ser nula")
    private DireccionSaveReq direccion;
}
