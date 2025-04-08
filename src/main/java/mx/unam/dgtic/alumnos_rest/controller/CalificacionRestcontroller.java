package mx.unam.dgtic.alumnos_rest.controller;

import mx.unam.dgtic.alumnos_rest.model.Calificacion;
import mx.unam.dgtic.alumnos_rest.service.v1.interfaces.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cals")
public class CalificacionRestcontroller {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/")
    public ResponseEntity<List<Calificacion>> getAll(){
        return ResponseEntity.ok(calificacionService.findAllCalificacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> getCalificacion(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Calificacion> createCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.saveCalificacion(calificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> updateCal(
            @PathVariable Long id,
            @RequestBody Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.updateCalificacion(id, calificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calificacion> deleteCal(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.deleteCalificacion(id));
    }


}
