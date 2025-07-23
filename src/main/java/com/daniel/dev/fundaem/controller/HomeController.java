package com.daniel.dev.fundaem.controller;


import com.daniel.dev.fundaem.dto.response.EventoResponse;
import com.daniel.dev.fundaem.model.Evento;
import com.daniel.dev.fundaem.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final EventoService eventoService;

    @GetMapping("/")
    public String index(Model model) {
        List<EventoResponse> todosLosEventos = eventoService.listarEventos();

        List<EventoResponse> primerosTresEventos = todosLosEventos.stream()
                .sorted(Comparator.comparing(EventoResponse::getFechaCreacion).reversed())
                .limit(3)
                .collect(Collectors.toList());

        model.addAttribute("eventos", primerosTresEventos);
        return "index";
    }

    @GetMapping("/eventos")
    public String verTodosLosEventos(Model model) {
        List<EventoResponse> todos = eventoService.listarEventos();
        model.addAttribute("eventos", todos);
        return "eventos/eventos";
    }


    @GetMapping("/dashboard")
    public String mostrarDashboard() {
        return "dashboard";
    }
}
