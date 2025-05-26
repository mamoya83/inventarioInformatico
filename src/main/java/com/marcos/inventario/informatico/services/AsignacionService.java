package com.marcos.inventario.informatico.services;

import com.marcos.inventario.informatico.models.Asignacion;
import com.marcos.inventario.informatico.repositories.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;

    public AsignacionService(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }
    //Metodo para obtener todas las  asignaciones
    public List<Asignacion> getAllAsignaciones(){
        return asignacionRepository.findAll();
    }
    //Metodo para obtener una asignacion por id
    public Optional<Asignacion> getAsignacionById(Long id){
        return asignacionRepository.findById(id);
    }
    //Metodo para crear una asignacion
    public Asignacion createAsignacion(Asignacion asignacion){
        return asignacionRepository.save(asignacion);
    }
    //Metodo para actualizar una asignacion
    public Optional<Asignacion> updateAsignacion(Long id, Asignacion asignacionAct){
        return asignacionRepository.findById(id).map(asignacion -> {
            asignacion.setEquipo(asignacionAct.getEquipo());
            asignacion.setUsuario(asignacionAct.getUsuario());
            asignacion.setFechaAsignacion(asignacionAct.getFechaAsignacion());
            return asignacionRepository.save(asignacion);
        });
    }
    //Metodo para eliminar una asignacion por id
    public Optional<Asignacion> deleteAsignacion(Long id){
        Optional<Asignacion> asignacion = asignacionRepository.findById(id);
        if(asignacion.isPresent()){
            Asignacion asignacionObt = asignacion.get();
            asignacionRepository.delete(asignacionObt);
            return Optional.of(asignacionObt);
        }else{
            return Optional.empty();
        }
    }
}
