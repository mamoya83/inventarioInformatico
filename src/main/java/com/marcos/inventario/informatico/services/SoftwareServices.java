package com.marcos.inventario.informatico.services;

import com.marcos.inventario.informatico.models.Software;
import com.marcos.inventario.informatico.repositories.SoftwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareServices {

    private final SoftwareRepository sofwareRepository;

    public SoftwareServices(SoftwareRepository sofwareRepository) {
        this.sofwareRepository = sofwareRepository;
    }
    //Metodo para obtener todos los Sofware
    public List<Software> getAllSoftwares(){
        return sofwareRepository.findAll();
    }
    //Metodo para obtener un software por su id
    public Optional<Software> getSoftwareById(Long id){
        return sofwareRepository.findById(id);
    }
    //Metodo para crear un nuevo software
    public Software createSoftware(Software software){
        return sofwareRepository.save(software);
    }
    //Metodo para actualizar un software
    public Optional<Software> updateSoftware(Long id,Software softwareAct){
        return sofwareRepository.findById(id).map(software -> {
            software.setNombre(softwareAct.getNombre());
            software.setVersion(softwareAct.getVersion());
            software.setLicencia(softwareAct.getLicencia());
            software.setFechaExpedicion(softwareAct.getFechaExpedicion());
            return sofwareRepository.save(software);
        });
    }
    //Metodo para eliminar un software por su id
    public Optional<Software> deleteSofware(Long id){
        Optional<Software>software = sofwareRepository.findById(id);
        if(software.isPresent()){
            Software softwareObt = software.get();
            sofwareRepository.delete(softwareObt);
            return Optional.of(softwareObt);
        }else{
            return Optional.empty();
        }
    }
}
