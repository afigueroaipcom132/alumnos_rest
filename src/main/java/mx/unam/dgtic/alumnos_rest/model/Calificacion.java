package mx.unam.dgtic.alumnos_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40)
    private String curso;

    @Column(nullable = false)
    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id",nullable = false)
    //@JsonIgnore
    @JsonBackReference
    private Alumno alumno;

}
