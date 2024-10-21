package com.facturacion.demo.services.impl;

import com.facturacion.demo.exceptions.NotFoundException;
import com.facturacion.demo.model.Usuario;
import com.facturacion.demo.repositories.UsuarioRepository;
import com.facturacion.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuarios(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean actualizarUsuario(Integer id, Usuario usuario) {
        if (usuarioRepository.existsById(String.valueOf(id))) {
            usuarioRepository.save(usuario);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(String.valueOf(id))) {
            usuarioRepository.deleteById(String.valueOf(id));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(String.valueOf(id)).orElseThrow(() -> new NotFoundException("No se encontro ID"));
    }
}
