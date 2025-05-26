package com.marcos.inventario.informatico.repositories;

import com.marcos.inventario.informatico.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    List<Equipo> findByEstado(String estado);
}
