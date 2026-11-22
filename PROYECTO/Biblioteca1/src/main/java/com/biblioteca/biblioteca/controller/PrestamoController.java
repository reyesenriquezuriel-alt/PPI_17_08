package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.biblioteca.biblioteca.dto.PrestamoDTO;
import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.service.PrestamoService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prestamo> listar() {
        return service.listar();
    }

    @PostMapping
    public Prestamo guardar(@RequestBody Prestamo prestamo) {
        return service.guardar(prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PostMapping("/prestar")
    public Prestamo prestar(
            @RequestBody PrestamoDTO dto) {

        return service.prestarLibro(
                dto.getUsuarioId(),
                dto.getLibroId());
    }

    @PutMapping("/devolver/{id}")
    public Prestamo devolver(
            @PathVariable Long id) {

        return service.devolverLibro(id);
    }
}