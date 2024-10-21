package com.facturacion.demo.repositories;

import com.facturacion.demo.model.ProductoLote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoLoteRepository extends JpaRepository<ProductoLote,Integer> {
}
