package com.marcos.inventario.informatico.controllers;

import com.marcos.inventario.informatico.models.Mantenimiento;
import com.marcos.inventario.informatico.services.MantenimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mantenimientos")
public class MantenimientoController {
    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }
    //Metodo para obtener todos los mantenimientos
    public ResponseEntity<List<Mantenimiento>>getAllMantenimientos(){
        List<Mantenimiento>mantenimientos = mantenimientoService.getAllMantenimientos();
        return ResponseEntity.ok(mantenimientos);
    }
    //Metodo para obtener un mantenimiento por id
    public ResponseEntity<Mantenimiento>getMantenimientoById(@PathVariable Long id){
        Optional<Mantenimiento>mantenimiento = mantenimientoService.getMantenimientoById(id);
        if(mantenimiento.isPresent()){
            return ResponseEntity.ok(mantenimiento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para crear un mentenimiento
    public ResponseEntity<Mantenimiento>createMantenimiento(@RequestBody Mantenimiento mantenimiento){
        Mantenimiento mantenimientoNuv = mantenimientoService.createMantenimiento(mantenimiento);
        return ResponseEntity.ok(mantenimientoNuv);
    }
    //Metodo para actualizar un mantenimiento
    public ResponseEntity<Mantenimiento>updateMantenimiento(@PathVariable Long id,@RequestBody Mantenimiento mantenimientoAct){
        Optional<Mantenimiento>mantenimientoActualizado = mantenimientoService.updateMantenimiento(id,mantenimientoAct);
        if(mantenimientoActualizado.isPresent()){
            return ResponseEntity.ok(mantenimientoActualizado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para eliminar un mantenimiento por id
    public ResponseEntity<Mantenimiento>deleteMantenimiento(@PathVariable Long id){
        Optional<Mantenimiento>mantenimientoElm = mantenimientoService.deleteMantenimiento(id);
        if(mantenimientoElm.isPresent()){
            return ResponseEntity.ok(mantenimientoElm.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
