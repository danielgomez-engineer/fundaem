package com.fundaem.fundaem.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class AuthRequestDTO {

    @Email
    private String email;
    private String password;
}
