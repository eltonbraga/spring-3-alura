package com.elton.spring.clinica.agendamedica.models.repositories;

import com.elton.spring.clinica.agendamedica.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<UserDetails> findByLogin(final String login);
}
