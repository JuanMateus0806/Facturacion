package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.Persona;
import com.facturacion.demo.repositories.PersonaRepository;
import com.facturacion.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean actualizarPersona(Integer id, Persona persona) {
        if (personaRepository.existsById(id)) {
            personaRepository.save(persona);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarPersona(Integer id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPersonaPorId(Integer id) {
        return personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
