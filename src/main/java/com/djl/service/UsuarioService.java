package com.djl.service;
import com.djl.domain.Usuario;
import com.djl.dto.request.UsuarioRequest;
import com.djl.dto.response.UsuarioResponse;
import com.djl.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    UsuarioResponse insertUsuario(UsuarioRequest usuarioDTO);

    List<UsuarioResponse> findAllUsuarios();

    UsuarioResponse updateUsuario(UsuarioRequest usuarioDTO, Integer uid);

    String deleteUsuario(Integer uid);
}
