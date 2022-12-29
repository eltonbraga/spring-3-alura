package com.elton.spring.clinica.agendamedica.configurations;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.elton.spring.clinica.agendamedica.models.repositories.UsuarioRepository;
import com.elton.spring.clinica.agendamedica.services.TokenService;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final String CABECALHO_DE_AUTORIZACAO = "Authorization";

    private final TokenService tokenService;

    private final UsuarioRepository repository;

    public SecurityFilter(final TokenService tokenService, final UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!request.getRequestURI().contains("/login")){
            final var tokenJwt = recuperaToken(request);
            final var userLogin = tokenService.validateTokenAndGetUserName(tokenJwt);

            final var usuario = repository.findByLogin(userLogin).orElseThrow();
            final var authenticatedUser = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperaToken(final HttpServletRequest request) {
        final var authorizationHeader = request.getHeader(CABECALHO_DE_AUTORIZACAO);

        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }
}
