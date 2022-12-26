package com.elton.spring.clinica.agendamedica.controllers.dto;

public record EnderecoDto(String logradouro, 
                            String bairro, 
                            String cep,
                            String cidade,
                            String estado,
                            String numero,
                            String complemento) {
    
}
