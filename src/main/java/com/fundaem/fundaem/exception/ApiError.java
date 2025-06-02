package com.fundaem.fundaem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class    ApiError {

    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;
    private List<String> details;
}
