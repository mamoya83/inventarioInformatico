package com.marcos.inventario.informatico.controllers;

import com.marcos.inventario.informatico.models.Software;
import com.marcos.inventario.informatico.services.SoftwareServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/softwares")
public class SoftwareController {
    private final SoftwareServices softwareServices;

    public SoftwareController(SoftwareServices softwareServices) {
        this.softwareServices = softwareServices;
    }

    //Metodo para obener todos los softwares
    @GetMapping
    public ResponseEntity<List<Software>> getAllSoftwares() {
        List<Software> softwares = softwareServices.getAllSoftwares();
        return ResponseEntity.ok(softwares);
    }

    //Metodo para obtener software por id
    @GetMapping("/{id}")
    public ResponseEntity<Software> getSoftwareById(@PathVariable Long id) {
        Optional<Software> software = softwareServices.getSoftwareById(id);
        if (software.isPresent()) {
            return ResponseEntity.ok(software.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para crear un software
    @PostMapping
    public ResponseEntity<Software> createSoftware(@RequestBody Software software) {
        Software softwareNuv = softwareServices.createSoftware(software);
        return ResponseEntity.ok(softwareNuv);
    }

    //Metodo para actualizar un sofware
    @PutMapping("/{id}")
    public ResponseEntity<Software> updateSoftware(@PathVariable Long id, @RequestBody Software softwareAct) {
        Optional<Software> softwareActulizado = softwareServices.updateSoftware(id, softwareAct);
        if (softwareActulizado.isPresent()) {
            return ResponseEntity.ok(softwareActulizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para eliminar un sofware por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Software>deleteSofware(Long id){
        Optional<Software>softwareElim = softwareServices.deleteSofware(id);
        if(softwareElim.isPresent()){
            return ResponseEntity.ok(softwareElim.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}






