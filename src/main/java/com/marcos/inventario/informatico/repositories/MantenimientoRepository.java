package com.marcos.inventario.informatico.repositories;

import com.marcos.inventario.informatico.models.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Long> {
}
