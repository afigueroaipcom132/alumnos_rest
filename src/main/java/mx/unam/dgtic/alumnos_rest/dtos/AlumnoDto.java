package mx.unam.dgtic.alumnos_rest.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDto {

    private Long id;

    @NotNull(message = "El nombre debe de proporcionarse")
    @Size(min = 3,max = 30,message = "Nombre no válido")
    @NotBlank(message = "Nombre no debe quedar en blanco")
    private String nombre;

    @NotNull(message = "El apellido debe de proporcionarse")
    @Size(min = 3,max = 50,message = "Apellido no válido")
    @NotBlank(message = "Apellido no debe quedar en blanco")
    private String apellido;

    @NotNull(message = "El email debe de proporcionarse")
    @Size(min = 10,max = 50,message = "Email no válido")
    @Email
    @NotBlank(message = "Correo no debe quedar en blanco")
    private String email;


}
