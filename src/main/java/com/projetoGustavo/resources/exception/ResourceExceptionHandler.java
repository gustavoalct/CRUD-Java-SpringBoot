package com.projetoGustavo.resources.exception;

import com.projetoGustavo.services.exceptions.DataIntegrityException;
import com.projetoGustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    // criando metodo
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage() , System.currentTimeMillis() ); // puxando do arquivo standartError

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandarError> DataIntegraty(DataIntegrityException e, HttpServletRequest request) {

        StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage() , System.currentTimeMillis() ); // puxando do arquivo standartError

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
