package com.elton.spring.clinica.agendamedica.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.spring.clinica.agendamedica.models.Medico;
import com.elton.spring.clinica.agendamedica.models.dtos.CadastrarMedicoDto;
import com.elton.spring.clinica.agendamedica.models.dtos.ListarMedicosDto;
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

    @Transactional(readOnly = true)
    public Page<ListarMedicosDto> listar(final Pageable paginacao){
        final Page<Medico> medicos = repository.findAll(paginacao);
        return medicos.map(ListarMedicosDto::new);
    }
   
}
