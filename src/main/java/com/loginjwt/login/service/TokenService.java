package com.loginjwt.login.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.loginjwt.login.model.LoginUsuario;

@Service
public class TokenService {
    String secret = "api.security.token.secret";

    public String generateToken(LoginUsuario user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api-login-java")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generationExpireDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar Token : ", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api-login-java")
                    .build()
                    .verify(token)
                    .getSubject();
           
        } catch (JWTVerificationException exception) {
            return "";
         // throw new RuntimeException("Erro ao recuperar Token : ", exception);
        }
    }

    private Instant generationExpireDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
