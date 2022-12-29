package com.elton.spring.clinica.agendamedica.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.elton.spring.clinica.agendamedica.models.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    private static final Long TEMPO_EXPIRACAO_EM_SEGUNDOS = 7200L; //7200 segundos ou 2 horas

    private static final String TOKEN_ISSUER = "API Medica";

    @Value("${api.security.token.secret}")
    @Getter
    @Setter
    private String secret;

    public String gerarJwtToken(final Usuario usuario){
        try {
            return JWT.create()
                    .withIssuer(TOKEN_ISSUER)
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(retornaDataDeExpiracao())
                    .sign( Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String validateTokenAndGetUserName(final String token){
        try {
          return  JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer(TOKEN_ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();                
        } catch (JWTVerificationException exception){
            //melhorar tipos de erro (expirado, invalido)
            throw new RuntimeException("Token jwt inválido.", exception);
        }
    }

    private Instant retornaDataDeExpiracao() {
        return Instant.now().plusSeconds(TEMPO_EXPIRACAO_EM_SEGUNDOS);
    }
}
