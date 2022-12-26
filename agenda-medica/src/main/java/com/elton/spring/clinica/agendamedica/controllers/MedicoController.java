package com.elton.spring.clinica.agendamedica.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elton.spring.clinica.agendamedica.controllers.dto.CadastrarMedicoDto;
import com.elton.spring.clinica.agendamedica.services.MedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    
    private final MedicoService service;

    public MedicoController(final MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Validated CadastrarMedicoDto cadastrarMedico){
        service.cadastrar(cadastrarMedico);   
    }
}
