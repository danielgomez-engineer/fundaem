package com.fundaem.fundaem.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoRequestDTO {

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    private String descripcion;

    @Future(message = "La fecha debe ser en el futuro")
    private LocalDate fecha;

    @NotBlank(message = "La url de la imagen es obligatoria")
    private String imagenUrl;

    private Long creador_id;
}
