package com.elton.spring.clinica.agendamedica.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.spring.clinica.agendamedica.controllers.dto.CadastrarMedicoDto;
import com.elton.spring.clinica.agendamedica.models.repositories.MedicoRepository;

@Service
public class MedicoService {
    
    private final MedicoRepository repository;

    public MedicoService(final MedicoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void cadastrar(final CadastrarMedicoDto cadastrarMedico) {
        repository.save(cadastrarMedico.toMedico());
    }
   
}
