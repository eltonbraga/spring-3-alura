package com.elton.spring.clinica.agendamedica.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    
    private String logradouro;

    private String bairro;

    private String cep;

    private String numero;

    private String complemento;

    private String estado;

    private String cidade;
}
