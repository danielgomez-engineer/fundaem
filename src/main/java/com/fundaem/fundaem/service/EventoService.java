package com.fundaem.fundaem.service;

import com.fundaem.fundaem.dto.request.EventoRequestDTO;
import com.fundaem.fundaem.dto.response.EventoResponseDTO;

import java.util.List;

public interface EventoService {

    EventoResponseDTO crearEvento (EventoRequestDTO request);

    List<EventoResponseDTO> listarEventos();

    EventoResponseDTO obtenerPorId(Long id);

    void eliminarEvento(Long id);

    EventoResponseDTO actualizarEvento(Long id, EventoRequestDTO request);

}
