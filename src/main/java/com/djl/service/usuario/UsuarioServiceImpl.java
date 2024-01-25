package com.djl.service.usuario;
import com.djl.domain.usuario.Usuario;
import com.djl.domain.usuario.dto.UsuarioRequest;
import com.djl.domain.usuario.dto.UsuarioResponse;
import com.djl.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponse> findAllUsuarios() {
        return usuarioRepository.findAll().stream().map(u -> modelMapper.map(u,UsuarioResponse.class)).toList();
    }

    @Override
    @Transactional
    public Optional<UsuarioResponse> saveUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = modelMapper.map(usuarioRequest, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        return Optional.ofNullable(modelMapper.map(usuario, UsuarioResponse.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioResponse> findById(Long uid) {
            Optional<Usuario> usuario = usuarioRepository.findById(uid);
        if (usuario.isPresent()) return Optional.of(modelMapper.map(usuario.get(), UsuarioResponse.class));
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<UsuarioResponse> update(Long uid, UsuarioRequest usuarioRequest) {
        Optional <Usuario> usuarioopt = usuarioRepository.findById(uid);
        if(usuarioopt.isPresent()){
            Usuario usuario = usuarioopt.get();
            modelMapper.map(usuarioRequest, usuario);
            usuario=usuarioRepository.save(usuario);
            return Optional.of(modelMapper.map(usuario, UsuarioResponse.class));

        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void delete(Long uid) {
        usuarioRepository.deleteById(uid);
    }


}
