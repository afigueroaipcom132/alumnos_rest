package mx.unam.dgtic.alumnos_rest.repository;

import mx.unam.dgtic.alumnos_rest.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {
}
