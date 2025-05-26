package com.marcos.inventario.informatico.controllers;

import com.marcos.inventario.informatico.models.Asignacion;
import com.marcos.inventario.informatico.services.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asignaciones")
public class AsignacionController {
    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    //Metodo para obtener todas las asignaciones
    @GetMapping
    public ResponseEntity<List<Asignacion>> getAllAsignaciones() {
        List<Asignacion> asignaciones = asignacionService.getAllAsignaciones();
        return ResponseEntity.ok(asignaciones);
    }

    //Metodo para obtener una signacion por id
    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> getAsignacionById(@PathVariable Long id) {
        Optional<Asignacion> asignacion = asignacionService.getAsignacionById(id);
        if (asignacion.isPresent()) {
            return ResponseEntity.ok(asignacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para crear una asignacion
    @PostMapping
    public ResponseEntity<Asignacion> createAsignacion(@RequestBody Asignacion asignacion) {
        Asignacion asignacionNuv = asignacionService.createAsignacion(asignacion);
        return ResponseEntity.ok(asignacionNuv);
    }

    //Metodo para actualizar asignacion
    @PutMapping("/{id}")
    public ResponseEntity<Asignacion> updateAsignacion(@PathVariable Long id, @RequestBody Asignacion asignacionAct) {
        Optional<Asignacion> asignacionActualizada = asignacionService.updateAsignacion(id, asignacionAct);
        if (asignacionActualizada.isPresent()) {
            return ResponseEntity.ok(asignacionActualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para eliminar asigancion por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Asignacion> deleteAsignacion(@PathVariable Long id) {
        Optional<Asignacion> asignacionElm = asignacionService.deleteAsignacion(id);
        if (asignacionElm.isPresent()) {
            return ResponseEntity.ok(asignacionElm.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
