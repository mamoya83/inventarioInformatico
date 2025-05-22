package com.marcos.inventario.informatico.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_software")
    private Long id;
    @Column(name = "nombres",nullable = false,length = 50)
    private String nombre;
    @Column(name = "versiones",nullable = false,length = 50)
    private String version;
    @Column(name = "liciencias",nullable = false,length = 50)
    private String licencia;
    @Column(name = "fechaExpedicion",nullable = false)
    private LocalDate fechaExpedicion;

    public Software() {
    }

    public Software(Long id, String nombre, String version, String licencia, LocalDate fechaExpedicion) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
        this.licencia = licencia;
        this.fechaExpedicion = fechaExpedicion;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
}
