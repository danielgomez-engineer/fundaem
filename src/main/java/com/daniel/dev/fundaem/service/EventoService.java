package com.daniel.dev.fundaem.service;

import com.daniel.dev.fundaem.dto.request.EventoRequest;
import com.daniel.dev.fundaem.dto.response.EventoResponse;

import java.util.List;

public interface EventoService {

    EventoResponse crearEvento(EventoRequest request, Long idCreador);

    List<EventoResponse> listarEventos();

    EventoResponse obtenerPorId(Long id);

    void eliminarEvento(Long id);

    void actualizarEvento (Long id, EventoRequest request);
}
