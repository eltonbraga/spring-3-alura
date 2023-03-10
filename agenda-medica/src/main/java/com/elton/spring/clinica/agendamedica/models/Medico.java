package com.elton.spring.clinica.agendamedica.models;

import com.elton.spring.clinica.agendamedica.models.enums.EspecialidadeMedica;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String crm;

    private String telefone;

    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private EspecialidadeMedica especialidade;

    @Embedded
    private Endereco endereco;

    public void desativar(){
        this.active = false;
    }

}
