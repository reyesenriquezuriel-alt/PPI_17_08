package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> listar() {
        return service.listar();
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return service.guardar(libro);
    }

    @GetMapping("/{id}")
    public Libro buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Libro actualizar(
            @PathVariable Long id,
            @RequestBody Libro libro) {

        return service.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        service.eliminar(id);
    }
}
