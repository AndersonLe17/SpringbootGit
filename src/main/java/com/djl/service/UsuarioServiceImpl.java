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
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioResponse insertUsuario(UsuarioRequest usuarioDTO) {
        Usuario usuario=modelMapper.map(usuarioDTO, Usuario.class);
        UsuarioResponse newUsuario=modelMapper.map(usuarioRepository.save(usuario), UsuarioResponse.class);
        return newUsuario;
    }

    @Override
    public List<UsuarioResponse> findAllUsuarios() {
        List<Usuario> usuarios=usuarioRepository.findAll();
        List<UsuarioResponse> usuarioResponse= usuarios.stream().map(u -> modelMapper.map(u,UsuarioResponse.class)).toList();
        return usuarioResponse;
    }

    @Override
    public UsuarioResponse updateUsuario(UsuarioRequest usuarioDTO, Integer uid) {
        Usuario usuario = usuarioRepository.findById(uid).orElseThrow();

        modelMapper.map(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
        UsuarioResponse response = modelMapper.map(usuario, UsuarioResponse.class);
        return response;
    }



    @Override
    public String deleteUsuario(Integer uid) {
        Usuario usuario=usuarioRepository.findById(uid).orElseThrow();
        usuarioRepository.delete(usuario);
        return "SE ELIMINO EL USUARIO";
    }


}
