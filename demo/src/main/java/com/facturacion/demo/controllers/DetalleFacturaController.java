package com.facturacion.demo.controllers;

import com.facturacion.demo.model.DetalleFactura;
import com.facturacion.demo.repositories.DetalleFacturaRepository;
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
@RequestMapping("api/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @GetMapping
    public ResponseEntity<Page<DetalleFactura>> listarDetallesFacturas(Pageable pageable){
        return ResponseEntity.ok(detalleFacturaRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> guardarDetallesFacturas(@Validated @RequestBody DetalleFactura detalleFactura){
        DetalleFactura detalleFacturaGuardada = detalleFacturaRepository.save(detalleFactura);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(detalleFacturaGuardada.getFactura()).toUri();
        return ResponseEntity.created(ubicacion).body(detalleFacturaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> actualizarDetalleFactura(@PathVariable Integer id , @Validated @RequestBody DetalleFactura detalleFactura){
        Optional<DetalleFactura> loteOptional = detalleFacturaRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        detalleFactura.setFactura(loteOptional.get().getFactura());
        detalleFacturaRepository.save(detalleFactura);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleFactura> eliminarDetallesFacturas(@PathVariable Integer id){
        Optional<DetalleFactura> facturaOptional = detalleFacturaRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        detalleFacturaRepository.delete(facturaOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> obtenerDetalleFacturaPorId(@PathVariable Integer id){
        Optional<DetalleFactura> facturaOptional = detalleFacturaRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(facturaOptional.get());
    }

}
