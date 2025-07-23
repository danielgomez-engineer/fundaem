package com.daniel.dev.fundaem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoResponse {

    private Long id;
    private String nombreEvento;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String urlVideo;
    private List<String> imagenes;
    private Long idUsuario;
    private String creadorNombre;
}
