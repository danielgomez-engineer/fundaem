package com.fundaem.fundaem.controller;

import com.fundaem.fundaem.dto.request.EventoRequestDTO;
import com.fundaem.fundaem.dto.response.EventoResponseDTO;
import com.fundaem.fundaem.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VistaEventoController {

    private final EventoService eventoService;

    public VistaEventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // ✅ Ver todos los eventos
    @GetMapping("/eventos")
    public String mostrarEventos(Model model) {
        List<EventoResponseDTO> eventos = eventoService.listarEventos();
        model.addAttribute("eventos", eventos);
        return "eventos"; // templates/eventos.html
    }

    // ✅ Formulario para crear nuevo evento
    @GetMapping("/eventos/nuevo")
    public String formularioNuevoEvento(Model model) {
        model.addAttribute("evento", new EventoRequestDTO());
        return "evento-crear"; // templates/evento-crear.html
    }

    // ✅ Procesar nuevo evento
    @PostMapping("/eventos")
    public String guardarEvento(@ModelAttribute EventoRequestDTO eventoDTO) {
        eventoService.crearEvento(eventoDTO);
        return "redirect:/eventos";
    }

    // ✅ Mostrar formulario de edición con datos precargados
    @GetMapping("/eventos/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        EventoResponseDTO evento = eventoService.obtenerPorId(id);
        model.addAttribute("evento", evento);
        return "evento-editar"; // templates/evento-editar.html
    }

    // ✅ Procesar edición del evento
    @PostMapping("/eventos/editar/{id}")
    public String actualizarEvento(@PathVariable Long id, @ModelAttribute EventoRequestDTO eventoDTO) {
        eventoService.actualizarEvento(id, eventoDTO);
        return "redirect:/eventos";
    }
}
