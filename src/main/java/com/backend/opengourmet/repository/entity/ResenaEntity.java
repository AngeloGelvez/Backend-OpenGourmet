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

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "fk_restaurante")
    private RestauranteEntity restauranteEntity;

    public ResenaEntity() {}

    public ResenaEntity(Long id, Integer calificacion, String comentario, LocalDate fecha, UsuarioEntity usuarioEntity, RestauranteEntity restauranteEntity) {
        this.id = id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuarioEntity = usuarioEntity;
        this.restauranteEntity = restauranteEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public RestauranteEntity getRestauranteEntity() {
        return restauranteEntity;
    }

    public void setRestauranteEntity(RestauranteEntity restauranteEntity) {
        this.restauranteEntity = restauranteEntity;
    }
}
