package com.elton.spring.clinica.agendamedica.models.dtos;

import com.elton.spring.clinica.agendamedica.models.Medico;
import com.elton.spring.clinica.agendamedica.models.enums.EspecialidadeMedica;

public record ListarMedicosDto(Long id, String nome, String email, String crm, EspecialidadeMedica especialidade, boolean active ) {
    
    public ListarMedicosDto(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.isActive());
    }
}
