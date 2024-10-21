package com.facturacion.demo.services.impl;


import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.DetalleFactura;
import com.facturacion.demo.repositories.DetalleFacturaRepository;
import com.facturacion.demo.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService{

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public DetalleFactura guardarDetallesFacturas(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    @Override
    public boolean actualizarDetalleFactura(Integer id, DetalleFactura detalleFactura) {
        if (detalleFacturaRepository.existsById(id)) {
            detalleFacturaRepository.save(detalleFactura);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarDetallesFacturas(Integer id) {
        if (detalleFacturaRepository.existsById(id)) {
            detalleFacturaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<DetalleFactura> listarDetallesFacturas() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public DetalleFactura obtenerDetalleFacturaPorId(Integer id) {
        return detalleFacturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
