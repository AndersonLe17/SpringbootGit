package com.djl.controller;

import com.djl.dto.request.UsuarioRequest;
import com.djl.dto.response.UsuarioResponse;
import com.djl.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Marca la clase como un controlador, maneja las solicitudes HTTP y produce respuestas JSON o XML
@RequestMapping("/api/usuarios")//comienza con la ruta
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<?> saveUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse response = usuarioService.saveUsuario(usuarioRequest).orElseThrow();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllUsuarios (){
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> findUsuarioById(@PathVariable("uid") Long uid ){
        Optional<UsuarioResponse> usuarioResponse = usuarioService.findById(uid);

        if (usuarioResponse.isPresent()) return ResponseEntity.ok(usuarioResponse.get());

        return ResponseEntity.notFound().build();

    }
    @PutMapping("/{uid}")
    public ResponseEntity<?> updatedUsuario(@PathVariable("uid") Long uid,
                                            @Valid @RequestBody UsuarioRequest usuarioRequest){
        Optional<UsuarioResponse> usuarioResponse = usuarioService.update(uid,usuarioRequest);
        if (usuarioResponse.isPresent()) return ResponseEntity.ok(usuarioResponse.get());
        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("uid") Long uid){
        Optional<UsuarioResponse> usuarioResponse = usuarioService.findById(uid);

        if (usuarioResponse.isPresent()) {
            usuarioService.delete(uid);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }




}
