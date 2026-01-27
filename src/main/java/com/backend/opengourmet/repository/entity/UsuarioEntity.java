package com.backend.opengourmet.repository.entity;

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

    //private List<ReservaEntity>
}
