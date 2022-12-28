package com.elton.spring.clinica.agendamedica.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elton.spring.clinica.agendamedica.configurations.domain.ApiError;

import jakarta.persistence.EntityNotFoundException;

@Configuration
@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError tratarErrorNaoEncontrado(final EntityNotFoundException exception){
        return new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage());
    }
}
