package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.ProductoLote;
import com.facturacion.demo.repositories.ProductoLoteRepository;
import com.facturacion.demo.services.ProductoLoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoLoteServiceImpl implements ProductoLoteService {

    @Autowired
    private ProductoLoteRepository productoLoteRepository;

    @Override
    public ProductoLote guardarProductosLote(ProductoLote productoLote) {
        return productoLoteRepository.save(productoLote);
    }

    @Override
    public boolean actualizarProductoLote(Integer id, ProductoLote productoLote) {
        if (productoLoteRepository.existsById(id)) {
            productoLoteRepository.save(productoLote);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarProductosLote(Integer id) {
        if (productoLoteRepository.existsById(id)) {
            productoLoteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ProductoLote> listarProductosLotes() {
        return productoLoteRepository.findAll();
    }

    @Override
    public ProductoLote obtenerProductoLotePorId(Integer id) {
        return productoLoteRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
