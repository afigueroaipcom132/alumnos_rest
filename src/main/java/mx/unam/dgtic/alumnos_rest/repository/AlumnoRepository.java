package mx.unam.dgtic.alumnos_rest.repository;

import mx.unam.dgtic.alumnos_rest.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

}
