package com.facturacion.demo.repositories;

import com.facturacion.demo.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura,Integer> {
}
