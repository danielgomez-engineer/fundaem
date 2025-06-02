package com.fundaem.fundaem.service;


import com.fundaem.fundaem.dto.request.UsuarioRequestDTO;
import com.fundaem.fundaem.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO request);

    List<UsuarioResponseDTO> listarUsuarios();

    UsuarioResponseDTO obtenerPorId(Long id);

    void eliminarUsuario(Long id);

}
