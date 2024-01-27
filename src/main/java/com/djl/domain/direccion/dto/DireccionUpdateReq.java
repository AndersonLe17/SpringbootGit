package com.djl.domain.direccion.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class DireccionUpdateReq {
    @Size(min = 3, max = 150, message = "La direccion debe tener mas de 3 caracteres")
    private String direccion;

    @Size(min = 3, max = 150, message = "El distrito debe tener mas de 3 caracteres")
    private String distrito;

    @Size(min = 3, max = 150, message = "La provincia debe tener mas de 3 caracteres")
    private String provincia;

    @Size(min = 3, max = 150, message = "El departamento debe tener mas de 3 caracteres")
    private String departamento;

    @Size(min = 3, max = 150, message = "El pais debe tener mas de 3 caracteres")
    private String pais;
}
