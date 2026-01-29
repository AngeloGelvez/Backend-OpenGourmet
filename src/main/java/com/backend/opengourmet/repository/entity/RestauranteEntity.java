package com.backend.opengourmet.repository.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

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

    @OneToMany
    private List<ResenaEntity> resenas;

    public RestauranteEntity() {}

    public RestauranteEntity(Long id, String nombre, String direccion, LocalTime horaApertura, LocalTime horaCierre) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public RestauranteEntity(Long id, String nombre, String direccion, LocalTime horaApertura, LocalTime horaCierre, List<ResenaEntity> resenas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.resenas = resenas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<ResenaEntity> getResenas() {
        return resenas;
    }

    public void setResenas(List<ResenaEntity> resenas) {
        this.resenas = resenas;
    }
}
