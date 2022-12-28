package com.elton.spring.clinica.agendamedica.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
