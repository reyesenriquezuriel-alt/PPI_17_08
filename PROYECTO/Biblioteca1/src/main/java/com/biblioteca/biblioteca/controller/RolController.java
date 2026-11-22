package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.biblioteca.biblioteca.entity.Rol;
import com.biblioteca.biblioteca.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rol> listar() {
        return service.listar();
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return service.guardar(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}