package com.marcos.inventario.informatico.services;

import com.marcos.inventario.informatico.models.Equipo;
import com.marcos.inventario.informatico.repositories.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }
    //Metodo para obtener todos los equipos
    public List<Equipo> getAllEquipos(){
        return equipoRepository.findAll();
    }
    //Metodo para obtener equipos por estado
    public List<Equipo> getEquiposPorEstado(String estado) {
        return equipoRepository.findByEstado(estado);
    }
    //Metodo para obtener el estdo por id
    public String getEstadoEquipo(Long id) {
        Optional<Equipo> equipoOptional = equipoRepository.findById(id);
        if (equipoOptional.isPresent()) {
            Equipo equipo = equipoOptional.get();
            return equipo.getEstado();
        } else {
            return "No encontrado";
        }
    }
    //Metodo para obtener un equipo por id
    public Optional<Equipo> getEquipoById(Long id){
        return equipoRepository.findById(id);
    }
    //Metodo para crear un equipo
    public Equipo createEquipo(Equipo equipo){
        return equipoRepository.save(equipo);
    }
    //Metodo para actualizar un equipo
    public  Optional<Equipo> updateEquipo(Long id,Equipo equipoAct){
        return equipoRepository.findById(id).map(equipo -> {
            equipo.setTipo(equipoAct.getTipo());
            equipo.setModelo(equipoAct.getModelo());
            equipo.setNumeroDeSerie(equipoAct.getNumeroDeSerie());
            equipo.setEstado(equipoAct.getEstado());
            equipo.setUbicacion(equipoAct.getUbicacion());
            return equipoRepository.save(equipo);
        });
    }
    //Metodo para eliminar un equipo por id
    public Optional<Equipo> deleteEquipo(Long id){
        Optional<Equipo> equipo = equipoRepository.findById(id);
        if(equipo.isPresent()){
            Equipo equipoObt = equipo.get();
            equipoRepository.delete(equipoObt);
            return Optional.of(equipoObt);
        }else{
            return Optional.empty();
        }
    }
}
