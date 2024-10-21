package com.facturacion.demo.services;

import com.facturacion.demo.model.DetalleFactura;

import java.util.List;

public interface DetalleFacturaService {

    DetalleFactura guardarDetallesFacturas(DetalleFactura detalleFactura);
    boolean actualizarDetalleFactura(Integer id, DetalleFactura detalleFactura);
    boolean eliminarDetallesFacturas(Integer id);
    List<DetalleFactura> listarDetallesFacturas();
    DetalleFactura obtenerDetalleFacturaPorId(Integer id);

}
