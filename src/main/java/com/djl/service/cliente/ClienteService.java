package com.djl.service.cliente;

import com.djl.domain.cliente.dto.ClienteRes;
import com.djl.domain.cliente.dto.ClienteSaveReq;
import com.djl.domain.cliente.dto.ClienteUpdateReq;

import java.util.Optional;

public interface ClienteService {
    boolean existsByEmail(String email);

    boolean existsByNumDocumento(String numDocumento);

    Optional<ClienteRes> save(ClienteSaveReq clienteSaveReq);

    Optional<ClienteRes> findById(Long cid);

    boolean existsByEmailAndId(String email, Long cid);

    boolean existsByNumDocumentoAndId(String numDocumento, Long cid);

    Boolean existsById(Long cid);

    Optional<ClienteRes> update(ClienteUpdateReq clienteUpdateReq, Long cid);
}
