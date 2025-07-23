package com.daniel.dev.fundaem.impl;

import com.daniel.dev.fundaem.dto.request.EventoRequest;
import com.daniel.dev.fundaem.dto.response.EventoResponse;
import com.daniel.dev.fundaem.exception.NotFoundException;
import com.daniel.dev.fundaem.model.Evento;
import com.daniel.dev.fundaem.model.Usuario;
import com.daniel.dev.fundaem.repository.EventoRepository;
import com.daniel.dev.fundaem.repository.UsuarioRepository;
import com.daniel.dev.fundaem.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoService {


    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;



    @Override
    public EventoResponse crearEvento(EventoRequest request, Long idCreador) {
        Usuario creador = usuarioRepository.findById(idCreador)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Evento evento = modelMapper.map(request, Evento.class);
        evento.setCreador(creador);
        Evento guardado = eventoRepository.save(evento);

        EventoResponse response = modelMapper.map(guardado, EventoResponse.class);
        response.setCreadorNombre(creador.getNombre());
        return response;
    }

    @Override
    public List<EventoResponse> listarEventos() {

        return eventoRepository.findAll().stream()
                .map(evento -> {
                    EventoResponse response = modelMapper.map(evento, EventoResponse.class);
                    response.setCreadorNombre(evento.getCreador().getNombre());
                    return response;
                }).collect(Collectors.toList());
    }

    @Override
    public EventoResponse obtenerPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento no encontrado"));
        EventoResponse response = modelMapper.map(evento, EventoResponse.class);
        response.setCreadorNombre(evento.getCreador().getNombre());
        return response;
    }

    @Override
    public void eliminarEvento(Long id) {
        if(!eventoRepository.existsById(id)) {
            throw new NotFoundException("Evento no encontrado con el id: " + id);
        }
        eventoRepository.deleteById(id);
    }

    @Override
    public void actualizarEvento(Long id, EventoRequest request) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento no encontrado con id " + id));

        modelMapper.map(request, evento);
        eventoRepository.save(evento);
    }
}
