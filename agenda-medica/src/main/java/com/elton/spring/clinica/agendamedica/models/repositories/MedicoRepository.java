package com.elton.spring.clinica.agendamedica.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.spring.clinica.agendamedica.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
    Page<Medico> findAllByActiveTrue(Pageable pageable);
}
