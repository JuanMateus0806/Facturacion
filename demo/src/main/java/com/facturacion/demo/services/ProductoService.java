package com.facturacion.demo.services;

import com.facturacion.demo.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardarProductos(Producto producto);
    boolean actualizarProducto(Integer id, Producto producto);
    boolean eliminarProducto(Integer id);
    List<Producto> listarProductos();
    Producto obtenerProductoPorId(Integer id);

}
