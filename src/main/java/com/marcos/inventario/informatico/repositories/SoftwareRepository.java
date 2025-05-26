package com.marcos.inventario.informatico.repositories;

import com.marcos.inventario.informatico.models.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepository extends JpaRepository<Software,Long> {
}
