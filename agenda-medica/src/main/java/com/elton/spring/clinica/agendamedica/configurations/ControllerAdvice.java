package com.elton.spring.clinica.agendamedica.configurations;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elton.spring.clinica.agendamedica.configurations.domain.ApiError;
import com.elton.spring.clinica.agendamedica.configurations.domain.ErroValidacao;

import jakarta.persistence.EntityNotFoundException;

@Configuration
@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError tratarErrorNaoEncontrado(final EntityNotFoundException exception){
        return new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError tratarErrosDeRequisicaoInvalida(MethodArgumentNotValidException exception){
        final var erros = exception.getFieldErrors();

        final List<ErroValidacao> errosTratados = erros.stream().map(erro -> new ErroValidacao(erro.getField(), erro.getDefaultMessage())).toList();

        return new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), "A requisição possui erro(s).", errosTratados);
    }
}
