package mx.unam.dgtic.alumnos_rest.controller.v2;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.service.v2.interfaces.AlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/paginable/alumnos")
public class AlumnoDtoRestControllerPageable {
    @Autowired
    private AlumnoDtoService alumnoDtoService;

    @GetMapping
    public ResponseEntity<List<AlumnoDto>> getPageableAlumnos(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer size,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "id") String sort
            ){
        return ResponseEntity.ok(alumnoDtoService.getPaginasAlumnosDto(page,size,direction,sort));
    }
}
