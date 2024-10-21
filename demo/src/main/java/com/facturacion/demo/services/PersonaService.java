package com.facturacion.demo.services;

import com.facturacion.demo.model.Persona;
import java.util.List;

public interface PersonaService {

    Persona guardarPersona(Persona persona);
    boolean actualizarPersona(Integer id, Persona persona);
    boolean eliminarPersona(Integer id);
    List<Persona> listarPersonas();
    Persona obtenerPersonaPorId(Integer id);
}
