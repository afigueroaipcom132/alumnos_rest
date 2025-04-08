package mx.unam.dgtic.alumnos_rest.service.v1.interfaces;

import mx.unam.dgtic.alumnos_rest.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlumnoService {
    public abstract List<Alumno>  findAllAlumnos();
    public abstract Alumno findById(Long id);
    public abstract Alumno saveAlumno(Alumno alumno);
    public abstract Alumno updateAlumno(Long id,Alumno alumno);
    public abstract Alumno deleteAlumno(Long id);

}
