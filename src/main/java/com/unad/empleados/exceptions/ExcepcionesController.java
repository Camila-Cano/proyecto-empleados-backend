package com.unad.empleados.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
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
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
