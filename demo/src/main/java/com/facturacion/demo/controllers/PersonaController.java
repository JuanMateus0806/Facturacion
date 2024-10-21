package com.facturacion.demo.controllers;


import com.facturacion.demo.model.Persona;
import com.facturacion.demo.repositories.PersonaRepository;
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
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public ResponseEntity<Page<Persona>> listarPersonas(Pageable pageable){
        return ResponseEntity.ok(personaRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@Validated @RequestBody Persona persona){
        Persona personaGuardada = personaRepository.save(persona);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(personaGuardada.getDocumento()).toUri();
        return ResponseEntity.created(ubicacion).body(personaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id ,@Validated @RequestBody Persona persona){
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (!personaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        persona.setDocumento(personaOptional.get().getDocumento());
        personaRepository.save(persona);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Integer id){
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (!personaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        personaRepository.delete(personaOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Integer id){
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (!personaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(personaOptional.get());
    }
}
