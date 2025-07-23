package com.daniel.dev.fundaem.service;

import com.daniel.dev.fundaem.dto.request.UsuarioRequest;
import com.daniel.dev.fundaem.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    UsuarioResponse registrarUsuario (UsuarioRequest request);

    List<UsuarioResponse> listarUsuarios();

    UsuarioResponse obtenerPorId(Long id);

    void eliminarUsuario(Long id);
}
