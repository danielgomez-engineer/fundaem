package com.daniel.dev.fundaem.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public String manejarNotFound(NotFoundException ex, Model model) {
        model.addAttribute("errorMensaje", ex.getMessage());
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public String manejarErroresGenerales(Exception ex, Model model) {
        model.addAttribute("errorMensaje", "Ha ocurrido un error inesperado.");
        return "error/general";
    }
}
