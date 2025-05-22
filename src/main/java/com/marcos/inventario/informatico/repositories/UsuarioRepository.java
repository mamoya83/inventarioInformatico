package com.marcos.inventario.informatico.repositories;

import com.marcos.inventario.informatico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
