package com.backend.opengourmet.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_usuarios", unique = true)
    private Long id;

    @Column(name = "nombre_usuarios")
    private String nombre;

    @Column(name = "apellido_usuarios")
    private String apellido;

    @Column(name = "email_usuarios", unique = true)
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy = "usuarioEntity",cascade = CascadeType.REMOVE, orphanRemoval = true) //Eliminacion en cascada
    private List<ReservaEntity> reservas;

    @JsonBackReference
    @OneToMany(mappedBy = "usuarioEntity" ,cascade = CascadeType.REMOVE, orphanRemoval = true) //Eliminacion en cascada
    private List<ResenaEntity> resenas;

    public UsuarioEntity() {}

    public UsuarioEntity(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioEntity(Long id, String nombre, String apellido, String email, List<ReservaEntity> reservas, List<ResenaEntity> resenas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.reservas = reservas;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public List<ResenaEntity> getResenas() {
        return resenas;
    }

    public void setResenas(List<ResenaEntity> resenas) {
        this.resenas = resenas;
    }
}
