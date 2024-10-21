package com.facturacion.demo.services;

import com.facturacion.demo.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario guardarUsuarios(Usuario usuario);
    boolean actualizarUsuario(Integer id, Usuario usuario);
    boolean eliminarUsuario(Integer id);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioPorId(Integer id);

}
