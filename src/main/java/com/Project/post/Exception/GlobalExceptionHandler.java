package com.Project.post.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerMethod(ResourceNotFoundException e, WebRequest webRequest){

    ErrorDetails e1 = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true)) ;

    return new ResponseEntity<>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodHandler(MethodArgumentNotValidException e){

     return new ResponseEntity<>(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> MethodHandler(EmptyResultDataAccessException e){


        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
