package com.djl.service.cliente;

import com.djl.domain.cliente.Cliente;
import com.djl.domain.cliente.dto.ClienteRes;
import com.djl.domain.cliente.dto.ClienteSaveReq;
import com.djl.domain.cliente.dto.ClienteUpdateReq;
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

    @Override
    public Optional<ClienteRes> findById(Long cid) {
        Optional<Cliente> cliente = clienteRepository.findById(cid);
        if (cliente.isPresent()) return Optional.ofNullable(modelMapper.map(cliente.get(), ClienteRes.class));

        return Optional.empty();
    }

    @Override
    public boolean existsByEmailAndId(String email, Long cid) {
        if (this.existsByEmail(email)) { // Hay algun cliente con el correo del DTO
            if (clienteRepository.existsByEmailAndId(email, cid)) { // Verificar si el correo le pertene al cliente del DTO
                return true;
            }
            return false; // El correo le pertenece a otro cliente
        }
        return true; // No hay ningun cliente con el correo del DTO
    }

    @Override
    public boolean existsByNumDocumentoAndId(String numDocumento, Long cid) {
        if (this.existsByNumDocumento(numDocumento)) { // Hay algun cliente con el numDocumento del DTO
            if (clienteRepository.existsByNumDocumentoAndId(numDocumento, cid)) { // Verificar si el numDocumento le pertene al cliente del DTO
                return true;
            }
            return false; // El numDocumento le pertenece a otro cliente
        }
        return true; // No hay ningun cliente con el numDocumento del DTO
    }

    @Override
    public Boolean existsById(Long cid) {
        return clienteRepository.existsById(cid);
    }

    @Override
    public Optional<ClienteRes> update(ClienteUpdateReq clienteUpdateReq, Long cid) {
        Cliente cliente = clienteRepository.findById(cid).get();
        modelMapper.map(clienteUpdateReq, cliente);

        cliente = clienteRepository.save(cliente);

        return Optional.ofNullable(modelMapper.map(cliente, ClienteRes.class));
    }
}
