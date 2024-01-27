package com.djl.repository;

import com.djl.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByNumDocumento(String numDocumento);
    Boolean existsByEmailAndId(String email, Long cid);
    Boolean existsByNumDocumentoAndId(String numDocumento, Long cid);
}
