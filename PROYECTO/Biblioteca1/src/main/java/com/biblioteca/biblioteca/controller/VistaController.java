package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/libros")
    public String libros() {
        return "libros";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios";
    }

    @GetMapping("/prestamos")
    public String prestamos() {
        return "prestamos";
    }

    @GetMapping("/reservas")
    public String reservas() {
        return "reservas";
    }

    @GetMapping("/reportes")
    public String reportes() {

        return "reportes";

    }
}
