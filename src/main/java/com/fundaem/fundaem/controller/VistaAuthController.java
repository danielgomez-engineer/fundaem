package com.fundaem.fundaem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaAuthController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // templates/login.html
    }

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register"; // templates/register.html
    }
}