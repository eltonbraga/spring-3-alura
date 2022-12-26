package com.elton.spring.clinica.agendamedica.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.spring.clinica.agendamedica.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
