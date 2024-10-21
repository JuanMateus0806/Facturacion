package com.facturacion.demo.controllers;

import com.facturacion.demo.model.ProductoLote;

import com.facturacion.demo.repositories.ProductoLoteRepository;
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
public class ProductoLoteController {

    @Autowired
    private ProductoLoteRepository productoLoteRepository;

    @GetMapping
    public ResponseEntity<Page<ProductoLote>> listarProductosLotes(Pageable pageable){
        return ResponseEntity.ok(productoLoteRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ProductoLote> guardarProductosLote(@Validated @RequestBody ProductoLote productoLote){
        ProductoLote detalleFacturaGuardada = productoLoteRepository.save(productoLote);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(detalleFacturaGuardada.getProducto()).toUri();
        return ResponseEntity.created(ubicacion).body(detalleFacturaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoLote> actualizarProductoLote(@PathVariable Integer id , @Validated @RequestBody ProductoLote productoLote){
        Optional<ProductoLote> loteOptional = productoLoteRepository.findById(id);
        if (!loteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        productoLote.setProducto(loteOptional.get().getProducto());
        productoLoteRepository.save(productoLote);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoLote> eliminarProductosLote(@PathVariable Integer id){
        Optional<ProductoLote> facturaOptional = productoLoteRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        productoLoteRepository.delete(facturaOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoLote> obtenerProductoLotePorId(@PathVariable Integer id){
        Optional<ProductoLote> facturaOptional = productoLoteRepository.findById(id);
        if (!facturaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(facturaOptional.get());
    }

}
