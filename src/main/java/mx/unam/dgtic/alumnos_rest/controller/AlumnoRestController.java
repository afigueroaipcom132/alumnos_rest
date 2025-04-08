package mx.unam.dgtic.alumnos_rest.controller;

import mx.unam.dgtic.alumnos_rest.model.Alumno;
import mx.unam.dgtic.alumnos_rest.service.v1.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoRestController {

    @Autowired
    private AlumnoService alumnoService;

    @Value("${mi.dbname}")
    private String variable;

    @GetMapping("/demo/")
    public String getDemo(){
        return variable;
    }

    @GetMapping("/")
    public ResponseEntity<List<Alumno>> getAllAlumnos(){
        return ResponseEntity.ok(alumnoService.findAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Long id){
        return ResponseEntity.ok(alumnoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.saveAlumno(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.updateAlumno(id,alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> deleteAlumno(@PathVariable Long id){
        return ResponseEntity.ok(alumnoService.deleteAlumno(id));
    }
}
