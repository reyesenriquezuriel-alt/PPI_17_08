package com.biblioteca.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import com.biblioteca.biblioteca.repository.ReservaRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DashboardController {

    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;
    private final PrestamoRepository prestamoRepository;
    private final ReservaRepository reservaRepository;

    public DashboardController(
            LibroRepository libroRepository,
            UsuarioRepository usuarioRepository,
            PrestamoRepository prestamoRepository,
            ReservaRepository reservaRepository) {

        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
        this.prestamoRepository = prestamoRepository;
        this.reservaRepository = reservaRepository;
    }

    @GetMapping("/api/dashboard")
    public Map<String, Long> dashboard() {

        Map<String, Long> datos = new HashMap<>();

        datos.put("libros", libroRepository.count());
        datos.put("usuarios", usuarioRepository.count());
        datos.put("prestamos", prestamoRepository.count());
        datos.put("reservas", reservaRepository.count());

        Long prestamosActivos = (long) prestamoRepository
                .findByEstado("ACTIVO")
                .size();

        datos.put(
                "prestamosActivos",
                prestamosActivos);
        return datos;

    }

}