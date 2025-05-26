package com.marcos.inventario.informatico.controllers;

import com.marcos.inventario.informatico.models.Equipo;
import com.marcos.inventario.informatico.services.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/equipos")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }
    //Metodo para obtener todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipo>>getAllEquipos(){
        List<Equipo>equipos = equipoService.getAllEquipos();
        return ResponseEntity.ok(equipos);
    }
    //Metodo para obtener un equipo por id
    @GetMapping("/{id}")
    public ResponseEntity<Equipo>getEquipoById(@PathVariable Long id){
        Optional<Equipo>equipo = equipoService.getEquipoById(id);
        if(equipo.isPresent()){
            return ResponseEntity.ok(equipo.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para obteber equipos por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Equipo>>getEquiposPorEstado(@PathVariable String estado){
        List<Equipo>equipos = equipoService.getEquiposPorEstado(estado);
        if(equipos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(equipos);
        }
    }
    //Metodo para obtener el estado por id
    @GetMapping("/{id}/estado")
    public ResponseEntity<Map<String, String>>getEstadoEquipo(@PathVariable Long id){
        String estado = equipoService.getEstadoEquipo(id);
        if("No encontrado".equalsIgnoreCase(estado)){
            return ResponseEntity.notFound().build();
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("estado",estado);
            return ResponseEntity.ok(response);
        }
    }
    //Metodo para crear un equipo
    @PostMapping
    public ResponseEntity<Equipo>createEquipo(@RequestBody Equipo equipo){
        Equipo equipoNuv = equipoService.createEquipo(equipo);
        return ResponseEntity.ok(equipoNuv);
    }
    //Metodo para actualizar un equipo
    @PutMapping("/{id}")
    public ResponseEntity<Equipo>updateEquipo(@PathVariable Long id, @RequestBody Equipo equipoAct){
        Optional<Equipo>equipoActualizado = equipoService.updateEquipo(id, equipoAct);
        if(equipoActualizado.isPresent()){
            return ResponseEntity.ok(equipoActualizado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para eliminar un equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo>deleteEquipo(@PathVariable Long id){
       Optional<Equipo> equipoElm = equipoService.deleteEquipo(id);
       if(equipoElm.isPresent()){
           return ResponseEntity.ok(equipoElm.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}
