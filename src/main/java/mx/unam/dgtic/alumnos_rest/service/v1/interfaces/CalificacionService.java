package mx.unam.dgtic.alumnos_rest.service.v1.interfaces;

import mx.unam.dgtic.alumnos_rest.model.Calificacion;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CalificacionService {
    public abstract List<Calificacion> findAllCalificacion();
    public abstract Calificacion findById(Long id);
    public abstract Calificacion saveCalificacion(Calificacion calificacion);
    public abstract Calificacion updateCalificacion(Long id,Calificacion calificacion);
    public abstract Calificacion deleteCalificacion(Long id);
}
