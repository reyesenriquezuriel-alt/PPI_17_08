package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.entity.Reserva;
import com.biblioteca.biblioteca.repository.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
