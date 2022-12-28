package com.elton.spring.clinica.agendamedica.configurations;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final String CABECALHO_DE_AUTORIZACAO = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!request.getRequestURI().contains("/login")){
            final var tokenJwt = recuperaToken(request);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperaToken(final HttpServletRequest request) {
        final var authorizationHeader = request.getHeader(CABECALHO_DE_AUTORIZACAO);

        if(authorizationHeader == null){
            throw new RuntimeException("Token é obrigatório!");
        }

        return authorizationHeader.replace("Bearer ", "");
    }
}
