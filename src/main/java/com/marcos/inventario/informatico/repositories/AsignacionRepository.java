package com.marcos.inventario.informatico.repositories;

import com.marcos.inventario.informatico.models.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {
}
