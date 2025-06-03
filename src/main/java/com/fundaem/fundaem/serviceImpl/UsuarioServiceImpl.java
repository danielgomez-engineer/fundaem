package com.fundaem.fundaem.serviceImpl;

import com.fundaem.fundaem.dto.request.UsuarioRequestDTO;
import com.fundaem.fundaem.dto.response.UsuarioResponseDTO;
import com.fundaem.fundaem.exception.NotFoundException;
import com.fundaem.fundaem.model.Rol;
import com.fundaem.fundaem.model.Usuario;
import com.fundaem.fundaem.repository.UsuarioRepository;
import com.fundaem.fundaem.service.UsuarioService;
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
    public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO request) {
        Usuario usuario = modelMapper.map(request, Usuario.class);
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        // Asignar el rol recibido en el request (ADMIN o CLIENTE)
        String rolStr = request.getRol();
        Rol rolAsignado;
        if (rolStr != null && rolStr.equalsIgnoreCase("ADMIN")) {
            rolAsignado = Rol.ADMIN;
        } else {
            rolAsignado = Rol.CLIENTE;
        }
        usuario.setRol(rolAsignado);
        Usuario guardado = usuarioRepository.save(usuario);
        return modelMapper.map(guardado, UsuarioResponseDTO.class);
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        return modelMapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFoundException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
