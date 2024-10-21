package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.Factura;
import com.facturacion.demo.repositories.FacturaRepository;
import com.facturacion.demo.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura guardarFacturas(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public boolean actualizarFactura(Integer id, Factura factura) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.save(factura);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarFacturas(Integer id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura obtenerFacturaPorId(Integer id) {
        return facturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
