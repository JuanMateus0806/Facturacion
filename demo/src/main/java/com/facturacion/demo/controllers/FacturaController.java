package com.facturacion.demo.controllers;

import com.facturacion.demo.model.Factura;
import com.facturacion.demo.repositories.FacturaRepository;
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
@RequestMapping("api/factura")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public ResponseEntity<Page<Factura>> listarFacturas(Pageable pageable){
        return ResponseEntity.ok(facturaRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Factura> guardarFacturas(@Validated @RequestBody Factura factura){
        Factura facturaGuardada = facturaRepository.save(factura);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(facturaGuardada.getIdFactura()).toUri();
        return ResponseEntity.created(ubicacion).body(facturaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Integer id , @Validated @RequestBody Factura factura){
        Optional<Factura> loteOptional = facturaRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        factura.setIdFactura(loteOptional.get().getIdFactura());
        facturaRepository.save(factura);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Factura> eliminarFacturas(@PathVariable Integer id){
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        facturaRepository.delete(facturaOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Integer id){
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(facturaOptional.get());
    }

}
