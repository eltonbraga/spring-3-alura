package com.elton.spring.clinica.agendamedica.models.dtos;

import com.elton.spring.clinica.agendamedica.models.Medico;
import com.elton.spring.clinica.agendamedica.models.enums.EspecialidadeMedica;

public record ListarMedicosDto(String nome, String email, String crm, EspecialidadeMedica especialidade ) {
    
    public ListarMedicosDto(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
