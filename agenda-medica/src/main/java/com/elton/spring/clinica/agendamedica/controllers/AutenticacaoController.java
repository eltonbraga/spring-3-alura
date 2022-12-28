package com.elton.spring.clinica.agendamedica.controllers;

import com.elton.spring.clinica.agendamedica.models.dtos.LoginDto;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    public AutenticacaoController(final AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public void login(@RequestBody @Valid LoginDto dados){
        final var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        manager.authenticate(token);
    }
}
