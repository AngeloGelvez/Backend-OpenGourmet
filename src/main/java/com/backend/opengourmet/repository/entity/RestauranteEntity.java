package com.backend.opengourmet.repository.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "restaurantes")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_restaurantes")
    private Long id;

    @Column(name = "nombre_restaurantes")
    private String nombre;

    @Column(name = "direccion_restaurantes")
    private String direccion;

    @Column(name = "hora_apertura_restaurantes")
    private LocalTime horaApertura;

    @Column(name = "hora_cierre_restaurantes")
    private LocalTime horaCierre;
}
