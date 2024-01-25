package com.djl.domain.producto;

import com.djl.domain.config.EntityBase;
import com.djl.domain.enums.Categoria;
import com.djl.domain.enums.EstadoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "productos")
public class Producto extends EntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(nullable = false, length = 25)
    private String marca;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false, precision = 2)
    private Double precio;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Categoria categoria;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private String imagen;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private EstadoProducto estado;
}
