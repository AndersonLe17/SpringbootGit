package com.djl.config.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDetail> handlerAppException(AppException exception, WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(
                new Date(),
                exception.getStatus().value(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> manejarResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handlerGlobalException(Exception exception, WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(
                new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldName, message);
        });
        ErrorValid errorValid = new ErrorValid(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                errors,
                request.getDescription(false)
        );

        return new ResponseEntity<>(errorValid, HttpStatus.BAD_REQUEST);
    }

}