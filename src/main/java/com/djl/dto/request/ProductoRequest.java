package com.djl.dto.request;

import com.djl.domain.enums.Categoria;
import com.djl.domain.enums.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductoRequest {
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private Categoria categoria;
    private Integer stock;
    private String imagen;
    private EstadoProducto estado;
}
