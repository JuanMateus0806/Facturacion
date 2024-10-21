package com.facturacion.demo.controllers;

import com.facturacion.demo.model.Producto;
import com.facturacion.demo.repositories.ProductoRepository;
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
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity<Page<Producto>> listarProductos(Pageable pageable){
        return ResponseEntity.ok(productoRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProductos(@Validated @RequestBody Producto producto){
        Producto productoGuardado = productoRepository.save(producto);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(productoGuardado.getIdProducto()).toUri();
        return ResponseEntity.created(ubicacion).body(productoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id , @Validated @RequestBody Producto producto){
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (!productoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        producto.setIdProducto(productoOptional.get().getIdProducto());
        productoRepository.save(producto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id){
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (!productoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        productoRepository.delete(productoOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id){
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (!productoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return  ResponseEntity.ok(productoOptional.get());
    }
}
