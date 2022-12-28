package com.elton.spring.clinica.agendamedica.controllers;

import com.elton.spring.clinica.agendamedica.models.Usuario;
import com.elton.spring.clinica.agendamedica.models.dtos.LoginDto;
import com.elton.spring.clinica.agendamedica.services.TokenService;
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

    private final TokenService tokenService;

    public AutenticacaoController(
            final AuthenticationManager manager,
            final TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public String login(@RequestBody @Valid LoginDto dados){
        final var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        final var auth = manager.authenticate(token);

        return tokenService.gerarJwtToken((Usuario) auth.getPrincipal());
    }
}
