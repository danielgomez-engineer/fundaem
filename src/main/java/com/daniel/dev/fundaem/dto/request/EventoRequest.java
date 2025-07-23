package com.daniel.dev.fundaem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoRequest {

    private Long id;

    @NotBlank(message = "El nombre del evento es obligatorio")
    private String nombreEvento;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fechaCreacion;

    @NotBlank(message = "el url del video es obligatorio")
    private String urlVideo;
    private List<String> imagenes;
    private Long idUsuario;

}

