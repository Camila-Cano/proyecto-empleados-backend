package com.unad.empleados.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExcepcionesController {

    @ExceptionHandler(EmpleadoNoEncotradoException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleEmpleadoNoEncontrado(EmpleadoNoEncotradoException ex) {
        log.info(ex.getMessage());
    }

    @ExceptionHandler(EmpleadoExistenteException.class)
    public ResponseEntity<Map<String,String>> handleEmpleadoExistente(EmpleadoExistenteException ex) {
        log.info(ex.getMessage());
        var map = Map.of("message", ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleBadRequest(MethodArgumentNotValidException ex) {
        log.info(ex.getMessage());
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            sb.append(String.format("%s:%s%n", fieldName, errorMessage));
        });
        return new ResponseEntity<>(Map.of("message", sb.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(EmpleadoExistenteException ex) {
        log.info(ex.getMessage());
        String msg = "Lo sentimos ocurrio un error inesperado";
        return new ResponseEntity<>(Map.of("message", msg), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
