package com.marcos.inventario.informatico.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignaciones",nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_equipo",nullable = false)
    private Equipo equipo;
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;
    @Column(name = "fecha_asignacion",nullable = false)
    private LocalDateTime fechaAsignacion;

    public Asignacion() {
    }

    public Asignacion(Long id, Equipo equipo, Usuario usuario, LocalDateTime fechaAsignacion) {
        this.id = id;
        this.equipo = equipo;
        this.usuario = usuario;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
