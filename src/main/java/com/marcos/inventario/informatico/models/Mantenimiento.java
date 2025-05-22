package com.marcos.inventario.informatico.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento",nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_equipo",nullable = false)
    private Equipo equipo;
    @Column(name = "tipo",nullable = false,length = 50)
    private String tipo;
    @Column(name = "fecha",nullable = false)
    private LocalDateTime fecha;
    @Column(name = "descripcion",nullable = false,length = 100)
    private String descripcion;

    public Mantenimiento() {
    }

    public Mantenimiento(Long id, Equipo equipo, String tipo, LocalDateTime fecha, String descripcion) {
        this.id = id;
        this.equipo = equipo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
