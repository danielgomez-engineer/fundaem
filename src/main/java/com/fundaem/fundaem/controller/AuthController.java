package com.fundaem.fundaem.controller;

import com.fundaem.fundaem.dto.request.AuthRequestDTO;
import com.fundaem.fundaem.dto.response.AuthResponseDTO;
import com.fundaem.fundaem.model.Usuario;
import com.fundaem.fundaem.repository.UsuarioRepository;
import com.fundaem.fundaem.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Usuario usuario = (Usuario) authentication.getPrincipal();
        String token = jwtUtils.generarToken(usuario);

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}
