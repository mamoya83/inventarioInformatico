package com.marcos.inventario.informatico.models;

import jakarta.persistence.*;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo",nullable = false)
    private Long id;
    @Column(name = "tipos",nullable = false,length = 50)
    private String tipo;
    @Column(name = "modelos",nullable = false, length = 50)
    private String modelo;
    @Column(name = "numero_series",nullable = false)
    private String numeroDeSerie;
    @Column(name = "estados",nullable = false, length = 50)
    private String estado;
    @Column(name = "ubicaciones",nullable = false)
    private String ubicacion;

    public Equipo() {
    }

    public Equipo(Long id, String tipo, String modelo, String numeroDeSerie, String estado, String ubicacion) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.numeroDeSerie = numeroDeSerie;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
