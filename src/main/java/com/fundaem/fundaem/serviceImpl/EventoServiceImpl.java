package com.fundaem.fundaem.serviceImpl;

import com.fundaem.fundaem.dto.request.EventoRequestDTO;
import com.fundaem.fundaem.dto.response.EventoResponseDTO;
import com.fundaem.fundaem.exception.NotFoundException;
import com.fundaem.fundaem.model.Evento;
import com.fundaem.fundaem.model.Usuario;
import com.fundaem.fundaem.repository.EventoRepository;
import com.fundaem.fundaem.repository.UsuarioRepository;
import com.fundaem.fundaem.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl  implements EventoService {

    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public EventoResponseDTO crearEvento(EventoRequestDTO request, Long creadorId) {

        Usuario creador = usuarioRepository.findById(creadorId)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Evento evento = modelMapper.map(request, Evento.class);
        evento.setCreador(creador);
        Evento guardado = eventoRepository.save(evento);

        EventoResponseDTO response = modelMapper.map(guardado, EventoResponseDTO.class);
        response.setCreadorNombre(creador.getNombre());
        return response;
    }

    @Override
    public List<EventoResponseDTO> listarEventos() {
        return eventoRepository.findAll().stream()
                .map(evento -> {
                    EventoResponseDTO dto = modelMapper.map(evento, EventoResponseDTO.class);
                    dto.setCreadorNombre(evento.getCreador().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EventoResponseDTO obtenerPorId(Long id) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento no encontrado"));
        EventoResponseDTO dto = modelMapper.map(evento, EventoResponseDTO.class);
        dto.setCreadorNombre(evento.getCreador().getNombre());
        return dto;
    }

    @Override
    public void eliminarEvento(Long id) {

        if(!eventoRepository.existsById(id)) {
            throw new NotFoundException("Evento no encontrado");
        }
        eventoRepository.deleteById(id);

    }

    @Override
    public void actualizarEvento(Long id, EventoRequestDTO request) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento no encontrado con ID: " + id));

        // Usamos ModelMapper para mapear los nuevos valores al evento existente
        modelMapper.map(request, evento);

        eventoRepository.save(evento);
    }


}
