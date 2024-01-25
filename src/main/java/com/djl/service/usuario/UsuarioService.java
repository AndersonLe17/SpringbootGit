package com.djl.service.usuario;
import com.djl.domain.usuario.dto.UsuarioRequest;
import com.djl.domain.usuario.dto.UsuarioResponse;
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
