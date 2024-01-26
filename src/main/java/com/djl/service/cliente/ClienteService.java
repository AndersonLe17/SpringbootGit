package com.djl.service.cliente;

import com.djl.domain.cliente.dto.ClienteRes;
import com.djl.domain.cliente.dto.ClienteSaveReq;

import java.util.Optional;

public interface ClienteService {
    boolean existsByEmail(String email);

    boolean existsByNumDocumento(String numDocumento);

    Optional<ClienteRes> save(ClienteSaveReq clienteSaveReq);
}
