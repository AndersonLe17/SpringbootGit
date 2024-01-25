package com.djl.domain.producto.dto;

import com.djl.domain.enums.Categoria;
import com.djl.domain.enums.EstadoProducto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductoUpdateReq {
    @Size(min = 3, max = 150, message = "El nombre debe tener mas de 3 caracteres")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @Size(min = 3, max = 25, message = "La marca debe tener mas de 3 caracteres")
    @NotBlank(message = "La marca no puede estar en blanco")
    private String marca;

    @Size(min = 3, max = 255, message = "La descripcion debe tener mas de 3 caracteres")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    private String descripcion;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private Double precio;

    private Categoria categoria;

    @Min(value = 0, message = "El stock debe ser mayor a 0")
    private Integer stock;

    @Size(min = 3, max = 255, message = "la url de la imagen debe tener mas de 3 caracteres")
    @Pattern(message = "La url de la imagen debe ser valida", regexp = "^(http(s?):\\/\\/).*$")
    @NotBlank(message = "La imagen no puede estar en blanco")
    private String imagen;

    private EstadoProducto estado;
}
