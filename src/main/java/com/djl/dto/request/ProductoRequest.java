package com.djl.dto.request;

import com.djl.domain.enums.Categoria;
import com.djl.domain.enums.EstadoProducto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductoRequest {
    @Size(min = 3, max = 150, message = "El nombre debe tener entre 3 y 150 caracteres")
    private String nombre;
    @Size(min = 3, max = 25)
    private String marca;
    @Size(min = 3, max = 255)
    private String descripcion;
    @DecimalMin(value = "0.0", inclusive = false)
    private Double precio;
    private Categoria categoria;
    @Min(value = 0)
    private Integer stock;
    @Size(min = 3, max = 255)
    private String imagen;
    private EstadoProducto estado;
}
