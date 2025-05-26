package com.marcos.inventario.informatico.controllers;

import com.marcos.inventario.informatico.models.Usuario;
import com.marcos.inventario.informatico.services.UsuarioService;
import jakarta.persistence.UniqueConstraint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    //Metodo para ontener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario>usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    //Metodo para obtener un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario>getUsuarioById(@PathVariable Long id){
       Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
       if(usuario.isPresent()){
           Usuario usuarioObt = usuario.get();
           return ResponseEntity.ok(usuarioObt);
       }else{
           return ResponseEntity.notFound().build();
       }
    }
    //Metodo para crear un usuario
    @PostMapping
    public ResponseEntity<Usuario>createUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNuv = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(usuarioNuv);
    }
    //Metodo para actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario>updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAct){
        Optional<Usuario>usuarioActualizado = usuarioService.updateUsuario(id,usuarioAct);
        if(usuarioActualizado.isPresent()){
            return ResponseEntity.ok(usuarioActualizado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para eliminar un usuario por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario>deleteUsuario(@PathVariable Long id){
        Optional<Usuario>usuarioEliminado = usuarioService.deleteUsuario(id);
        if(usuarioEliminado.isPresent()){
            return  ResponseEntity.ok(usuarioEliminado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
