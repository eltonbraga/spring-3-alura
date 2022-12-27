package com.elton.spring.clinica.agendamedica.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elton.spring.clinica.agendamedica.models.dtos.CadastrarMedicoDto;
import com.elton.spring.clinica.agendamedica.models.dtos.ListarMedicosDto;
import com.elton.spring.clinica.agendamedica.services.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    
    private final MedicoService service;

    public MedicoController(final MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid CadastrarMedicoDto cadastrarMedico){
        service.cadastrar(cadastrarMedico);   
    }

    @GetMapping
    public Page<ListarMedicosDto> listar(@PageableDefault(size = 10, sort = {"nome"}) final Pageable paginacao){
        return service.listar(paginacao);
    }
}
