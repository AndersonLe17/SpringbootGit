package com.djl.controller;

import com.djl.dto.request.UsuarioRequest;
import com.djl.dto.response.UsuarioResponse;
import com.djl.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Marca la clase como un controlador, maneja las solicitudes HTTP y produce respuestas JSON o XML
@RequestMapping("/api/usuariosprueba")//comienza con la ruta
public class UsuarioController {

    @Autowired //utiliza para realizar la inyección de dependencias
    private UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioRequest usuarioDTO){
        UsuarioResponse newUsuario = usuarioService.insertUsuario(usuarioDTO);
        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsuarios(){
        List<UsuarioResponse> usuarios = usuarioService.findAllUsuarios();
        return ResponseEntity.ok(usuarios);

    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> updatedUsuario(@RequestBody UsuarioRequest usuarioDTO, @PathVariable(name="uid") Integer uid){
        UsuarioResponse updateUsuario=usuarioService.updateUsuario(usuarioDTO,uid);
        return ResponseEntity.ok(updateUsuario==null? "ERROR AL MODIFICAR":updateUsuario);
    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable(name="uid") Integer uid){
        String respuesta=usuarioService.deleteUsuario(uid);
        return ResponseEntity.ok(respuesta);
    }




}
