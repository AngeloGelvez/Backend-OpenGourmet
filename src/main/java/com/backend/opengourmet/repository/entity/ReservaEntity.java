package com.backend.opengourmet.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_reservas")
    private Long id;

    @Column(name = "fecha_reservas")
    private LocalDate fecha;

    @Column(name = "hora_inicio_reservas")
    private LocalTime horaInicio;

    @Column(name = "hora_fin_reservas")
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    // TIPOS DE ESTADOS
    public enum Estado {
        RESERVADO, // 0
        DISPONIBLE, // 1
        CANCELADO // 2
};
}
