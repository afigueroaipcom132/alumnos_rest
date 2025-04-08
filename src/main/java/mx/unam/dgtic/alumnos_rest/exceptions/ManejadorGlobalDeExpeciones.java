package mx.unam.dgtic.alumnos_rest.exceptions;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

@RestControllerAdvice
public class ManejadorGlobalDeExpeciones {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> manejarPeticionesErroneas(
            HttpMessageNotReadableException httpMessageNotReadableException,
            HttpServletRequest httpServletRequest){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("mensaje","Error en la petición");
        hashMap.put("timeStamp", LocalDateTime.now().toString());
        hashMap.put("ruta",httpServletRequest.getRequestURI());
        hashMap.put("code",400);
        //return ResponseEntity.ok(hashMap);
        return ResponseEntity.badRequest().body(hashMap);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,Object>> erroresValidacion(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpServletRequest httpServletRequest){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("mensaje","Error de validación");
        hashMap.put("timeStamp", LocalDateTime.now().toString());
        hashMap.put("ruta",httpServletRequest.getRequestURI());

        HashMap<String,String> detalleCampos = new HashMap<>();

        for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            detalleCampos.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        hashMap.put("detalle", detalleCampos);


        //return ResponseEntity.ok(hashMap);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(hashMap);
    }
}
