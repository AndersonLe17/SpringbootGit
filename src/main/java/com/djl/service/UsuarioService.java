package com.djl.service;
import com.djl.dto.request.UsuarioRequest;
import com.djl.dto.response.UsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {


    List<UsuarioResponse> findAllUsuarios();

    Optional<UsuarioResponse> saveUsuario(UsuarioRequest usuarioRequest);

    Optional<UsuarioResponse> findById(Long uid);

    Optional<UsuarioResponse> update(Long uid, UsuarioRequest usuarioRequest);

    void delete(Long uid);
}
