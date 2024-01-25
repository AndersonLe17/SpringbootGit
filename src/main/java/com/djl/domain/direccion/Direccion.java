package com.djl.domain.direccion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "direcciones")
public class Direccion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String direccion;
    @Column(nullable = false, length = 150)
    private String distrito;
    @Column(nullable = false, length = 150)
    private String provincia;
    @Column(nullable = false, length = 150)
    private String departamento;
    @Column(nullable = false, length = 150)
    private String pais;
}
