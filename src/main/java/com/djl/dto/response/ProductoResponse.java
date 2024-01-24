package com.djl.dto.response;

import com.djl.domain.enums.Categoria;
import com.djl.domain.enums.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private Categoria categoria;
    private Integer stock;
    private String imagen;
    private EstadoProducto estado;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
