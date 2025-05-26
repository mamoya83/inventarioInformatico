package com.marcos.inventario.informatico.services;

import com.marcos.inventario.informatico.models.Mantenimiento;
import com.marcos.inventario.informatico.repositories.MantenimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    public MantenimientoService(MantenimientoRepository mantenimientorpository) {
        this.mantenimientoRepository = mantenimientorpository;
    }

    //Metodo para obtener todos los mantenimientos
    public List<Mantenimiento> getAllMantenimientos(){
        return mantenimientoRepository.findAll();
    }
    //Metodo para obtener mantenimiento por id
    public Optional<Mantenimiento> getMantenimientoById(Long id){
        return mantenimientoRepository.findById(id);
    }
    //Metodo para crear mantenimiento
    public Mantenimiento createMantenimiento(Mantenimiento mantenimiento){
        return mantenimientoRepository.save(mantenimiento);
    }
    //Metodo para actualizar un mantenimiento
    public Optional<Mantenimiento> updateMantenimiento(Long id,Mantenimiento mantenimientoAct){
        return mantenimientoRepository.findById(id).map(mantenimiento -> {
            mantenimiento.setEquipo(mantenimientoAct.getEquipo());
            mantenimiento.setTipo(mantenimientoAct.getTipo());
            mantenimiento.setFecha(mantenimientoAct.getFecha());
            mantenimiento.setDescripcion(mantenimientoAct.getDescripcion());
            return mantenimientoRepository.save(mantenimiento);
        });
    }
    //Metodo para eliminar mantenimiento por id
    public Optional<Mantenimiento> deleteMantenimiento(Long id){
        Optional<Mantenimiento> mantenimiento = mantenimientoRepository.findById(id);
        if(mantenimiento.isPresent()){
            Mantenimiento mantenimientoObt = mantenimiento.get();
            mantenimientoRepository.delete(mantenimientoObt);
            return Optional.of(mantenimientoObt);
        }else{
            return Optional.empty();
        }

    }
}
