package com.facturacion.demo.controllers;

import com.facturacion.demo.model.Usuario;
import com.facturacion.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(Pageable pageable){
        return ResponseEntity.ok(usuarioRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuarios(@Validated @RequestBody Usuario usuario){
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(usuarioGuardado.getLogin()).toUri();
        return ResponseEntity.created(ubicacion).body(usuarioGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id , @Validated @RequestBody Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(String.valueOf(id));
        if (!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        usuario.setLogin(usuarioOptional.get().getLogin());
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Integer id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(String.valueOf(id));
        if (!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        usuarioRepository.delete(usuarioOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(String.valueOf(id));
        if (!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(usuarioOptional.get());
    }

}
