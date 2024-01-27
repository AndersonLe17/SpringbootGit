package com.djl.controller;

import com.djl.config.exceptions.EntityRulesException;
import com.djl.config.exceptions.ResourceNotFoundException;
import com.djl.domain.cliente.dto.ClienteRes;
import com.djl.domain.cliente.dto.ClienteSaveReq;
import com.djl.domain.cliente.dto.ClienteUpdateReq;
import com.djl.service.cliente.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<?> saveCliente(@Valid @RequestBody ClienteSaveReq clienteSaveReq) {
        if (clienteService.existsByEmail(clienteSaveReq.getEmail()))
            throw new EntityRulesException("El email ya existe");
        if (clienteService.existsByNumDocumento(clienteSaveReq.getNumDocumento()))
            throw new EntityRulesException("El número de documento ya existe");

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteSaveReq));
    }

    @GetMapping("/{cid}")
    public ResponseEntity<?> findClienteById(@PathVariable("cid") Long cid) {
        Optional<ClienteRes> clienteRes = clienteService.findById(cid);
        if (!clienteRes.isPresent())
            throw new ResourceNotFoundException("Cliente", "ID", cid);

        return ResponseEntity.ok(clienteRes);
    }

    @PutMapping("/{cid}")
    public ResponseEntity<?> updateClienteById(@PathVariable("cid") Long cid, @Valid @RequestBody ClienteUpdateReq clienteUpdateReq) {
        Boolean clienteRes = clienteService.existsById(cid);

        if (!clienteRes)
            throw new ResourceNotFoundException("Cliente", "ID", cid);
        if (clienteUpdateReq.getEmail() != null && !clienteService.existsByEmailAndId(clienteUpdateReq.getEmail(), cid))
            throw new EntityRulesException("El email ya existe");
        if (clienteUpdateReq.getNumDocumento() != null && !clienteService.existsByNumDocumentoAndId(clienteUpdateReq.getNumDocumento(), cid))
            throw new EntityRulesException("El número de documento ya existe");

        return ResponseEntity.ok(clienteService.update(clienteUpdateReq, cid));
    }

}
