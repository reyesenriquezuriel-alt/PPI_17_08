package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.entity.Rol;
import com.biblioteca.biblioteca.repository.RolRepository;

@Service
public class RolService {

    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> listar() {
        return repository.findAll();
    }

    public Rol guardar(Rol rol) {
        return repository.save(rol);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}