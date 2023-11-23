package com.example.demoPrueba.controller;

import com.example.demoPrueba.exception.ResourceNotFoundException;
import com.example.demoPrueba.model.Usuario;
import com.example.demoPrueba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();

    }
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existente con id:" + id));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable long id,@RequestBody Usuario usuarioDetails){
        Usuario updateUsuario = usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario no existente con id:" +id));

        updateUsuario.setNombre(usuarioDetails.getNombre());
        updateUsuario.setEmail(usuarioDetails.getEmail());

        usuarioRepository.save(updateUsuario);

        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario no existente con el id:" + id));

        usuarioRepository.delete(usuario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
