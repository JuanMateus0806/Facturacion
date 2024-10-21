package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.facturacion.demo.model.Producto;
import java.util.List;
import com.facturacion.demo.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProductos(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean actualizarProducto(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            productoRepository.save(producto);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
