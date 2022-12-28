package com.elton.spring.clinica.agendamedica.configurations.domain;

public record ApiError (int statusCode, String error, String message){}
