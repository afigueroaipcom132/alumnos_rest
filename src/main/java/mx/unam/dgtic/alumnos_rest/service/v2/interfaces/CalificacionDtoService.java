package mx.unam.dgtic.alumnos_rest.service.v2.interfaces;

import mx.unam.dgtic.alumnos_rest.dtos.CalificacionDto;
import mx.unam.dgtic.alumnos_rest.model.Calificacion;

import java.util.List;

public interface CalificacionDtoService {
    public abstract List<CalificacionDto> findAllCalificacion();
    public abstract CalificacionDto findById(Long id);
    public abstract CalificacionDto saveCalificacion(CalificacionDto calificacionDto);
    public abstract CalificacionDto updateCalificacion(Long id,CalificacionDto calificacionDto);
    public abstract CalificacionDto deleteCalificacion(Long id);
}
