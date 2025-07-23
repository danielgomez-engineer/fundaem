package com.daniel.dev.fundaem.controller;


import com.daniel.dev.fundaem.dto.request.EventoRequest;
import com.daniel.dev.fundaem.dto.response.EventoResponse;
import com.daniel.dev.fundaem.model.Usuario;
import com.daniel.dev.fundaem.service.EventoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;



   @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/eventos")
    public String verEventosAdmin(Model model) {
       model.addAttribute("eventos", eventoService.listarEventos());
       return "eventos/admin_eventos";
   }


   @PreAuthorize("hasRole('ADMIN')")
   @GetMapping("/eventos/new")
   public String mostrarFormularioCreacion(Model model) {
       model.addAttribute("evento", new EventoRequest());
       return "eventos/evento_crear";
   }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eventos")
    public String guardarEvento(
            @Valid @ModelAttribute("evento") EventoRequest request,
            @AuthenticationPrincipal Usuario usuarioAutenticado,
            BindingResult result
    ) {

       if(result.hasErrors()) {
           return "eventos/evento_crear";
       }
        eventoService.crearEvento(request, usuarioAutenticado.getId());
        return "redirect:/admin/eventos";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eventos/editar/{id}")
    public String mostrarFormularioEditar (Model model,@PathVariable Long id) {
       model.addAttribute("evento", new EventoRequest());
       EventoResponse evento = eventoService.obtenerPorId(id);

       EventoRequest request = new EventoRequest();
        request.setId(evento.getId());
       request.setNombreEvento(evento.getNombreEvento());
       request.setDescripcion(evento.getDescripcion());
       request.setFechaCreacion(evento.getFechaCreacion());
       request.setUrlVideo(evento.getUrlVideo());

       model.addAttribute("evento", request);
       return "eventos/evento_editar";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eventos/editar/{id}")
    public String actualizarEvento(
            @PathVariable Long id,
            @Valid  @ModelAttribute("evento") EventoRequest request,
            BindingResult result
    ) {

       if(result.hasErrors()) {
           return "eventos/evento_editar";
       }
        request.setId(id);
        eventoService.actualizarEvento(id,request);
        return "redirect:/admin/eventos";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eventos/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return "redirect:/admin/eventos";
    }

}
