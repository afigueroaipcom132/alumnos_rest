package mx.unam.dgtic.alumnos_rest.service.v1;

import mx.unam.dgtic.alumnos_rest.model.Calificacion;
import mx.unam.dgtic.alumnos_rest.repository.CalificacionRepository;
import mx.unam.dgtic.alumnos_rest.service.v1.interfaces.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public List<Calificacion> findAllCalificacion() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion findById(Long id) {
        return calificacionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se a econtrado en find by id")
        );
    }

    @Override
    public Calificacion saveCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion updateCalificacion(Long id, Calificacion calificacion) {
        return calificacionRepository.findById(id)
                .map(calificacionExistente -> {
                    //calificacionExistente.setAlumno(calificacion.getAlumno());
                    calificacionExistente.setCurso(calificacion.getCurso());
                    calificacionExistente.setNota(calificacion.getNota());
                    return calificacionRepository.save(calificacionExistente);
                }).orElseThrow( () -> new RuntimeException("Alumno no encontrado"));
    }

    @Override
    public Calificacion deleteCalificacion(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("La calificación no se encuentra en delete"));
        calificacionRepository.deleteById(id);
        return calificacion;
    }
}
