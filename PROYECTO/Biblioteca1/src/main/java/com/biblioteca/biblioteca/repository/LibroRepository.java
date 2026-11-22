package com.biblioteca.biblioteca.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTituloContaining(String titulo);

    List<Libro> findByAutorContaining(String autor);

    List<Libro> findByCategoriaContaining(String categoria);
}