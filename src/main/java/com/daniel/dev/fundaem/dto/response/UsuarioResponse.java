package com.daniel.dev.fundaem.dto.response;

import com.daniel.dev.fundaem.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private Rol rol;
}
