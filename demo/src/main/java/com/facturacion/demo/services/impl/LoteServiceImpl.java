package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.Lote;
import com.facturacion.demo.services.LoteService;
import com.facturacion.demo.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LoteServiceImpl implements LoteService {

    @Autowired
    private LoteRepository loteRepository;

    @Override
    public Lote guardarLotes(Lote lote) {
        return loteRepository.save(lote);
    }

    @Override
    public boolean actualizarLote(Integer id, Lote lote) {
        if (loteRepository.existsById(id)) {
            loteRepository.save(lote);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarLote(Integer id) {
        if (loteRepository.existsById(id)) {
            loteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Lote> listarLotes() {
        return loteRepository.findAll();
    }

    @Override
    public Lote obtenerLotePorId(Integer id) {
        return loteRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
