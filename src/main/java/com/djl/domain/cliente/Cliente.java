package com.djl.domain.cliente;

import com.djl.domain.direccion.Direccion;
import com.djl.domain.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String apellido;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TipoDocumento tipoDocumento;
    @Column(nullable = false, length = 15, unique = true)
    private String numDocumento;
    @Column(nullable = false, length = 255, unique = true)
    private String email;
    @Column(nullable = false, length = 9)
    private String celular;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
    private Direccion direccion;

}
