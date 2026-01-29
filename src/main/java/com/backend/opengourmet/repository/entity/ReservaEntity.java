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

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "fk_mesa")
    private MesaEntity mesaEntity;

    public ReservaEntity() {}

    public ReservaEntity(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Estado estado, UsuarioEntity usuarioEntity, MesaEntity mesaEntity) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.usuarioEntity = usuarioEntity;
        this.mesaEntity = mesaEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public MesaEntity getMesaEntity() {
        return mesaEntity;
    }

    public void setMesaEntity(MesaEntity mesaEntity) {
        this.mesaEntity = mesaEntity;
    }
}
