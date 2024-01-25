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
public class ProductoSaveReq {
    @Size(min = 3, max = 150, message = "El nombre debe tener mas de 3 caracteres")
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @Size(min = 3, max = 25, message = "La marca debe tener mas de 3 caracteres")
    @NotNull(message = "La marca no puede ser nula")
    @NotBlank(message = "La marca no puede estar en blanco")
    private String marca;

    @Size(min = 3, max = 255, message = "La descripcion debe tener mas de 3 caracteres")
    @NotNull(message = "La descripcion no puede ser nula")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    private String descripcion;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @NotNull(message = "El precio no puede ser nulo")
    private Double precio;

    @NotNull(message = "La categoria no puede ser nula")
    private Categoria categoria;

    @Min(value = 0, message = "El stock debe ser mayor a 0")
    @NotNull(message = "El stock no puede ser nulo")
    private Integer stock;

    @Size(min = 3, max = 255, message = "la url de la imagen debe tener mas de 3 caracteres")
    @Pattern(message = "La url de la imagen debe ser valida", regexp = "^(http(s?):\\/\\/).*$")
    @NotNull(message = "La imagen no puede ser nula")
    @NotBlank(message = "La imagen no puede estar en blanco")
    private String imagen;

    @NotNull(message = "El estado no puede ser nulo")
    private EstadoProducto estado = EstadoProducto.ACTIVO;
}
