package com.elton.spring.clinica.agendamedica.configurations.domain;

import java.util.List;

public record ApiError (int statusCode, String error, String message, List<ErroValidacao> errors){}
