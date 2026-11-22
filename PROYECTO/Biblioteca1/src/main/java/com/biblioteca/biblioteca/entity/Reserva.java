package com.biblioteca.biblioteca.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate fechaReserva;

    @ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;

@ManyToOne
@JoinColumn(name = "libro_id")
private Libro libro;
}