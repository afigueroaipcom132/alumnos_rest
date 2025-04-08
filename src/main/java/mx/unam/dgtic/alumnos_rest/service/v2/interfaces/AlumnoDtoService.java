package mx.unam.dgtic.alumnos_rest.service.v2.interfaces;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.model.Alumno;

import java.util.List;

public interface AlumnoDtoService {
    public abstract List<AlumnoDto> findAllAlumnos();
    public abstract AlumnoDto findById(Long id);
    public abstract AlumnoDto saveAlumno(AlumnoDto AlumnoDto);
    public abstract AlumnoDto updateAlumno(Long id,AlumnoDto alumnoDto);
    public abstract AlumnoDto deleteAlumno(Long id);
    public abstract List<AlumnoDto> getPaginasAlumnosDto(
            Integer page,
            Integer size,
            String direction,
            String sort
    );
}
