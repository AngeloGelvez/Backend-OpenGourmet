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

    @ManyToOne
    @JoinColumn(name = "fk_restaurante")
    private RestauranteEntity restauranteEntity;

    public MesaEntity() {}

    public MesaEntity(Long id, Integer numero, Integer capacidad, RestauranteEntity restauranteEntity) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.restauranteEntity = restauranteEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public RestauranteEntity getRestauranteEntity() {
        return restauranteEntity;
    }

    public void setRestauranteEntity(RestauranteEntity restauranteEntity) {
        this.restauranteEntity = restauranteEntity;
    }
}
