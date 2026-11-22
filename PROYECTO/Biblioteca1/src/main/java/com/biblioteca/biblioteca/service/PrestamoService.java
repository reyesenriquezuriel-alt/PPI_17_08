package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;

@Service

public class PrestamoService {

    public Prestamo prestarLibro(Long usuarioId, Long libroId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();

        Libro libro = libroRepository.findById(libroId).orElseThrow();

        if (libro.getDisponibles() <= 0) {

            throw new RuntimeException(
                    "No hay ejemplares disponibles");
        }

        Prestamo prestamo = new Prestamo();

        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);

        prestamo.setEstado("ACTIVO");

        libro.setDisponibles(
                libro.getDisponibles() - 1);

        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }

    public Prestamo devolverLibro(Long id) {

        Prestamo prestamo = prestamoRepository
                .findById(id)
                .orElseThrow();

        Libro libro = prestamo.getLibro();

        libro.setDisponibles(
                libro.getDisponibles() + 1);

        prestamo.setEstado("DEVUELTO");

        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }

    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    public PrestamoService(
            PrestamoRepository prestamoRepository,
            UsuarioRepository usuarioRepository,
            LibroRepository libroRepository) {

        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
    }

    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }
}