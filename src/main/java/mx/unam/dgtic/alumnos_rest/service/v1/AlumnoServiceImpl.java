package mx.unam.dgtic.alumnos_rest.service.v1;

import mx.unam.dgtic.alumnos_rest.model.Alumno;
import mx.unam.dgtic.alumnos_rest.repository.AlumnoRepository;
import mx.unam.dgtic.alumnos_rest.service.v1.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No sencontrado en find by id")
        );
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno updateAlumno(Long id, Alumno alumno) {
        return alumnoRepository.findById(id)
                .map(alumnoExistente -> {
                    alumnoExistente.setNombre(alumno.getNombre());
                    alumnoExistente.setApellido(alumno.getApellido());
                    alumnoExistente.setEmail(alumno.getEmail());
                    return alumnoRepository.save(alumnoExistente);
                }).orElseThrow( () -> new RuntimeException("Alumno no encontrado"));
    }

    @Override
    public Alumno deleteAlumno(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("El alumno no se necuentra en delete"));
        alumnoRepository.deleteById(id);
        return alumno;
    }
}
