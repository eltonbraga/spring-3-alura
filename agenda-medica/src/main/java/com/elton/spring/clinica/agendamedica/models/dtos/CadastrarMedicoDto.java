package com.elton.spring.clinica.agendamedica.models.dtos;

import com.elton.spring.clinica.agendamedica.models.Endereco;
import com.elton.spring.clinica.agendamedica.models.Medico;
import com.elton.spring.clinica.agendamedica.models.enums.EspecialidadeMedica;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastrarMedicoDto(
                            @NotBlank
                            String nome,
                            @NotBlank
                            @Email 
                            String email,
                            @NotBlank
                            @Pattern(regexp = "\\d{4,6}")
                            String crm, 
                            @NotNull
                            EspecialidadeMedica especialidade, 
                            @NotNull
                            @Valid
                            EnderecoDto endereco,
                            @NotBlank
                            String telefone
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
                                this.telefone, 
                                this.especialidade, 
                                endereco);
        }
}
