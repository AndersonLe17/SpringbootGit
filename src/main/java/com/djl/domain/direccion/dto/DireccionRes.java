package com.djl.domain.direccion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class DireccionRes {
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private String pais;
}
