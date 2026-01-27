package com.backend.opengourmet.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class MesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_mesas")
    private Long id;

    @Column(name = "numero_mesas")
    private Integer numero;

    @Column(name = "capacidad_mesas")
    private Integer capacidad;
}
