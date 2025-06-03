package com.fundaem.fundaem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private String imagenUrl;
    private Boolean activo;
    private UsuarioResponseDTO creador;
}
