package mx.unam.dgtic.alumnos_rest.service.v2;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.model.Alumno;
import mx.unam.dgtic.alumnos_rest.repository.AlumnoRepository;
import mx.unam.dgtic.alumnos_rest.service.v2.interfaces.AlumnoDtoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoDtoServiceImpl implements AlumnoDtoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AlumnoDto> findAllAlumnos() {
        return alumnoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDto findById(Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encuentra el alumno en getUno DTO")
        );
        return convertToDto(alumno);
    }

    @Override
    public AlumnoDto saveAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = convertToEntity(alumnoDto);
        return convertToDto(alumnoRepository.save(alumno));
    }

    @Override
    public AlumnoDto updateAlumno(Long id, AlumnoDto alumnoDto) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontró el alumno a modificar")
        );
        updateAlumnoFromDTO(alumnoDto,alumno);
        return convertToDto(alumnoRepository.save(alumno));
    }

    @Override
    public AlumnoDto deleteAlumno(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró el alumno")
                );
        alumnoRepository.deleteById(id);
        return convertToDto(alumno);
    }

    @Override
    public List<AlumnoDto> getPaginasAlumnosDto(Integer page, Integer size, String direction, String sort) {

        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.fromString(direction),sort);
        Page<Alumno> page1 = alumnoRepository.findAll(pageRequest);
        return page1.getContent().stream().map(
                this::convertToDto
        ).collect(Collectors.toList());
    }

    private AlumnoDto convertToDto(Alumno alumno){
        return modelMapper.map(alumno,AlumnoDto.class );
    }

    private Alumno convertToEntity(AlumnoDto alumnoDto){
        return modelMapper.map(alumnoDto,Alumno.class );
        // calcular promedio
        // concatenar los nombres
        //
//        TypeMap<Alumno, AlumnoDto> miTypeMap= modelMapper.createTypeMap(Alumno.class, AlumnoDto.class);
//        miTypeMap.addMapping(
//                origen ->  origen.getNombre() + " " + origen.getApellido() , AlumnoDto::setFullName
//        );
//        return modelMapper.map(alumno, AlumnoDto)

    }

    private void updateAlumnoFromDTO(AlumnoDto alumnoDto, Alumno alumno){
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEmail(alumnoDto.getEmail());
    }

}
