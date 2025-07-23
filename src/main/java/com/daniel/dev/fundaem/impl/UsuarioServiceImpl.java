package com.daniel.dev.fundaem.impl;

import com.daniel.dev.fundaem.dto.request.UsuarioRequest;
import com.daniel.dev.fundaem.dto.response.UsuarioResponse;
import com.daniel.dev.fundaem.exception.NotFoundException;
import com.daniel.dev.fundaem.model.Rol;
import com.daniel.dev.fundaem.model.Usuario;
import com.daniel.dev.fundaem.repository.UsuarioRepository;
import com.daniel.dev.fundaem.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest request) {
        Usuario usuario = modelMapper.map(request, Usuario.class);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.CLIENTE); // al momento de crear un usuario se crea de tipo cliente
        Usuario guardado = usuarioRepository.save(usuario);
        return modelMapper.map(guardado, UsuarioResponse.class);
    }

    @Override
    public List<UsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro usuario con el id: " + id));
        return modelMapper.map(usuario, UsuarioResponse.class);
    }

    @Override
    public void eliminarUsuario(Long id) {

        if(!usuarioRepository.existsById(id)) {
            throw new NotFoundException("No se encontro usuario con el id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
