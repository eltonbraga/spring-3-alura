package com.elton.spring.clinica.agendamedica.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(
                            @NotBlank
                            String logradouro, 
                            @NotBlank
                            String bairro,
                            @NotBlank 
                            String cep,
                            @NotBlank
                            String cidade,
                            @NotBlank
                            String estado,
                            String numero,
                            String complemento) {
    
}
