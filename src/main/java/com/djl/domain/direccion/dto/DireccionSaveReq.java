package com.djl.domain.direccion.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class DireccionSaveReq {
    @Size(min = 3, max = 150, message = "La direccion debe tener mas de 3 caracteres")
    @NotNull(message = "La direccion no puede ser nula")
    @NotBlank(message = "La direccion no puede estar en blanco")
    private String direccion;

    @Size(min = 3, max = 150, message = "El distrito debe tener mas de 3 caracteres")
    @NotNull(message = "El distrito no puede ser nulo")
    @NotBlank(message = "El distrito no puede estar en blanco")
    private String distrito;

    @Size(min = 3, max = 150, message = "La provincia debe tener mas de 3 caracteres")
    @NotNull(message = "La provincia no puede ser nula")
    @NotBlank(message = "La provincia no puede estar en blanco")
    private String provincia;

    @Size(min = 3, max = 150, message = "El departamento debe tener mas de 3 caracteres")
    @NotNull(message = "El departamento no puede ser nulo")
    @NotBlank(message = "El departamento no puede estar en blanco")
    private String departamento;

    @Size(min = 3, max = 150, message = "El pais debe tener mas de 3 caracteres")
    @NotNull(message = "El pais no puede ser nulo")
    @NotBlank(message = "El pais no puede estar en blanco")
    private String pais;
}
