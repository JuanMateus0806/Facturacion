package com.facturacion.demo.repositories;

import com.facturacion.demo.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<Lote,Integer> {
}
