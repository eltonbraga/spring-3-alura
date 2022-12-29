package com.elton.spring.clinica.agendamedica.services;

import com.elton.spring.clinica.agendamedica.models.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    public AutenticacaoService(final UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final Optional<UserDetails> usuario = repository.findByLogin(login);

        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário e/ou senha inválidos.");
        }

        return usuario.get();
    }
}
