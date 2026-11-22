package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}