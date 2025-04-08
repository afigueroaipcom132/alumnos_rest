package mx.unam.dgtic.alumnos_rest.controller.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.service.v2.interfaces.AlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/alumnos")
public class AlumnoDtoRestController {

    @Autowired
    private AlumnoDtoService alumnoDtoService;

    @GetMapping("/")
    public ResponseEntity<List<AlumnoDto>> getAllAlumnosDto(){
        return ResponseEntity.ok(alumnoDtoService.findAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> getAlumnoDto(@PathVariable Long id){
        return ResponseEntity.ok(alumnoDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<AlumnoDto> newAlumnoDto(@Valid @RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.ok(alumnoDtoService.saveAlumno(alumnoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDto> updateAlumnoDto(@Valid @PathVariable Long id, @RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.ok(alumnoDtoService.updateAlumno(id,alumnoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDto> deleteAlumnoDto(@PathVariable Long id){
        return ResponseEntity.ok(alumnoDtoService.deleteAlumno(id));
    }


}
