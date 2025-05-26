package com.marcos.inventario.informatico.services;

import com.marcos.inventario.informatico.models.Usuario;
import com.marcos.inventario.informatico.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //Metodo para obtener todos los usuarios
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    //Metodo para obtener un usuario por id
    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
    //Metodo para crear un usuario
    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //Metodo para actualizar un usuario
    public Optional<Usuario> updateUsuario(Long id,Usuario usuarioAct) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioAct.getNombre());
            usuario.setCargo(usuarioAct.getCargo());
            usuario.setDepartamento(usuarioAct.getDepartamento());
            return usuarioRepository.save(usuario);
        });
    }
    //Metodo para eliminar un usuario por id
    public Optional<Usuario> deleteUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            Usuario usuarioObt = usuario.get();
            usuarioRepository.delete(usuarioObt);
            return Optional.of(usuarioObt);
        }else{
            return Optional.empty();
        }
    }



}
