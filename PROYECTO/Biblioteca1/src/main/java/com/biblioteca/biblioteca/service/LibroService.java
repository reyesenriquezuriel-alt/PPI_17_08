package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;

@Service
public class LibroService {

    public Libro buscarPorId(Long id) {

        return repository.findById(id)
                .orElse(null);

    }

    public Libro actualizar(
            Long id,
            Libro libro) {

        Libro actual = repository.findById(id)
                .orElse(null);

        if (actual != null) {

            actual.setTitulo(
                    libro.getTitulo());

            actual.setAutor(
                    libro.getAutor());

            actual.setCategoria(
                    libro.getCategoria());

            actual.setIsbn(
                    libro.getIsbn());

            actual.setStock(
                    libro.getStock());

            actual.setDisponibles(
                    libro.getDisponibles());

            return repository.save(actual);

        }

        return null;
    }

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> listar() {
        return repository.findAll();
    }

    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    public void eliminar(Long id) {

        repository.deleteById(id);

    }
}