package mx.unam.dgtic.alumnos_rest.service.v2;

import mx.unam.dgtic.alumnos_rest.dtos.CalificacionDto;
import mx.unam.dgtic.alumnos_rest.service.v2.interfaces.CalificacionDtoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalificacionDtoServiceImpl implements CalificacionDtoService {
    @Override
    public List<CalificacionDto> findAllCalificacion() {
        return List.of();
    }

    @Override
    public CalificacionDto findById(Long id) {
        return null;
    }

    @Override
    public CalificacionDto saveCalificacion(CalificacionDto calificacionDto) {
        return null;
    }

    @Override
    public CalificacionDto updateCalificacion(Long id, CalificacionDto calificacionDto) {
        return null;
    }

    @Override
    public CalificacionDto deleteCalificacion(Long id) {
        return null;
    }
}
