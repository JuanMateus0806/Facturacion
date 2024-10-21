package com.facturacion.demo.services;

import com.facturacion.demo.model.ProductoLote;

import java.util.List;

public interface ProductoLoteService {

    ProductoLote guardarProductosLote(ProductoLote productoLote);
    boolean actualizarProductoLote(Integer id, ProductoLote productoLote);
    boolean eliminarProductosLote(Integer id);
    List<ProductoLote> listarProductosLotes();
    ProductoLote obtenerProductoLotePorId(Integer id);

}
