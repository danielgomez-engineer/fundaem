package com.daniel.dev.fundaem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

@NotBlank(message = "El nombre es obligatorio")
private String nombre;

@NotBlank(message = "El Email es obligatorio")
private String email;

@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$", message = "La contraseña debe tener letras y números")
private String password;

}
