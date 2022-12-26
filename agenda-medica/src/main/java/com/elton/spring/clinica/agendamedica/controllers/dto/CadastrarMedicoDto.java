package com.elton.spring.clinica.agendamedica.controllers.dto;

import com.elton.spring.clinica.models.enums.EspecialidadeMedica;

public record CadastrarMedicoDto(String nome, 
                            String email, 
                            String telefone,
                            String crm, 
                            EspecialidadeMedica especialidade, 
                            EnderecoDto endereco
                        ){}
