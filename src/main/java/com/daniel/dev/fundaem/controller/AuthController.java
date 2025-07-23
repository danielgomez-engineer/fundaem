package com.daniel.dev.fundaem.controller;


import com.daniel.dev.fundaem.dto.request.UsuarioRequest;
import com.daniel.dev.fundaem.repository.UsuarioRepository;
import com.daniel.dev.fundaem.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuarioRequest", new UsuarioRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@Valid @ModelAttribute UsuarioRequest usuarioRequest, BindingResult result) {

        if (result.hasErrors()) {
            return "auth/register";
        }
        usuarioService.registrarUsuario(usuarioRequest);
        return "redirect:/auth/login?success";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "auth/login";
    }

}
