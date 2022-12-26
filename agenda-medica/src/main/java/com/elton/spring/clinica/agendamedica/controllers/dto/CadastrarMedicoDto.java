package com.elton.spring.clinica.agendamedica.controllers.dto;

import com.elton.spring.clinica.agendamedica.models.Endereco;
import com.elton.spring.clinica.agendamedica.models.Medico;
import com.elton.spring.clinica.agendamedica.models.enums.EspecialidadeMedica;

public record CadastrarMedicoDto(String nome, 
                            String email, 
                            String telefone,
                            String crm, 
                            EspecialidadeMedica especialidade, 
                            EnderecoDto endereco
                        ){

        public Medico toMedico(){
            final Endereco endereco = new Endereco(
                                    this.endereco.logradouro(), 
                                    this.endereco.bairro(), 
                                    this.endereco.cep(), 
                                    this.endereco.numero(), 
                                    this.endereco.complemento(), 
                                    this.endereco.estado(),
                                    this.endereco().cidade());

            return new Medico(null, 
                                this.nome, 
                                this.email,
                                this.crm, 
                                this.especialidade, 
                                endereco);
        }
}
