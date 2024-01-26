package com.djl.service.cliente;

import com.djl.domain.cliente.Cliente;
import com.djl.domain.cliente.dto.ClienteRes;
import com.djl.domain.cliente.dto.ClienteSaveReq;
import com.djl.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean existsByEmail(String email) {
        if (clienteRepository.existsByEmail(email)) return true;
        return false;
    }

    @Override
    public boolean existsByNumDocumento(String numDocumento) {
        if (clienteRepository.existsByNumDocumento(numDocumento)) return true;
        return false;
    }

    @Override
    public Optional<ClienteRes> save(ClienteSaveReq clienteSaveReq) {
        Cliente cliente = modelMapper.map(clienteSaveReq, Cliente.class);
        cliente = clienteRepository.save(cliente);

        return Optional.ofNullable(modelMapper.map(cliente, ClienteRes.class));
    }
}
