package com.backend.opengourmet.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "resenas")
public class ResenaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_resenas")
    private Long id;

    @Column(name = "calificacion_resenas")
    private Integer calificacion;

    @Column(name = "comentario_resenas")
    private String comentario;

    @Column(name = "fecha_resenas")
    private LocalDate fecha;
}
