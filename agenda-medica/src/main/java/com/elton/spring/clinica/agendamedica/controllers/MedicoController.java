package com.elton.spring.clinica.agendamedica.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elton.spring.clinica.agendamedica.controllers.dto.CadastrarMedicoDto;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    
    @PostMapping
    public void cadastrar(@RequestBody @Validated CadastrarMedicoDto cadastrarMedico){
        System.out.println(cadastrarMedico);
    }
}
