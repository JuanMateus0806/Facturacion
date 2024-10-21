package com.facturacion.demo.services;

import com.facturacion.demo.model.Factura;

import java.util.List;

public interface FacturaService {

    Factura guardarFacturas(Factura factura);
    boolean actualizarFactura(Integer id, Factura factura);
    boolean eliminarFacturas(Integer id);
    List<Factura> listarFacturas();
    Factura obtenerFacturaPorId(Integer id);

}
