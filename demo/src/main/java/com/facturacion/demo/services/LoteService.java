package com.facturacion.demo.services;

import com.facturacion.demo.model.Lote;

import java.util.List;

public interface LoteService {

    Lote guardarLotes(Lote lote);
    boolean actualizarLote(Integer id, Lote lote);
    boolean eliminarLote(Integer id);
    List<Lote> listarLotes();
    Lote obtenerLotePorId(Integer id);

}
