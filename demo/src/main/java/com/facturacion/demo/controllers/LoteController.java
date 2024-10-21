package com.facturacion.demo.controllers;

import com.facturacion.demo.model.Lote;
import com.facturacion.demo.repositories.LoteRepository;
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
@RequestMapping("/api/lote")
public class LoteController {

    @Autowired
    private LoteRepository loteRepository;

    @GetMapping
    public ResponseEntity<Page<Lote>> listarLotes(Pageable pageable){
        return ResponseEntity.ok(loteRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Lote> guardarLotes(@Validated @RequestBody Lote lote){
        Lote loteGuardado = loteRepository.save(lote);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(loteGuardado.getIdLote()).toUri();
        return ResponseEntity.created(ubicacion).body(loteGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> actualizarLote(@PathVariable Integer id , @Validated @RequestBody Lote lote){
        Optional<Lote> loteOptional = loteRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        lote.setIdLote(loteOptional.get().getIdLote());
        loteRepository.save(lote);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lote> eliminarLote(@PathVariable Integer id){
        Optional<Lote> loteOptional = loteRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        loteRepository.delete(loteOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> obtenerLotePorId(@PathVariable Integer id){
        Optional<Lote> loteOptional = loteRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(loteOptional.get());
    }

}
