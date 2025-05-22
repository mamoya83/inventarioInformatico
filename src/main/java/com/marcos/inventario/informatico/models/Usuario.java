package com.marcos.inventario.informatico.models;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private Long id;
    @Column(name = "nombres",nullable = false, length = 50)
    private String nombre;
    @Column(name = "cargos",nullable = false,length = 50)
    private String cargo;
    @Column(name = "departamentos",nullable = false,length = 50)
    private String departamento;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String cargo, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.departamento = departamento;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
