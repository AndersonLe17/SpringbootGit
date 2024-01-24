package com.djl.domain;

import com.djl.domain.enums.EstadoUsuario;
import com.djl.domain.enums.Rol;
import com.djl.domain.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data  @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name="usuarios")
public class Usuario extends EntityBase{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TipoDocumento tipoDocumento;
    @Column(nullable = false)
    private String numDocumento;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    @Column(length = 100, nullable = false)
    private String username;
    @Column(length=100, nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Rol rol;
    @Column(length = 20, nullable = true)
    private String password;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private EstadoUsuario estado;
    @Temporal(TemporalType.DATE) @Column(nullable=false)
    private Date fechaNacimiento;
    @Column(length = 9, nullable = false)
    private String celular;



}
