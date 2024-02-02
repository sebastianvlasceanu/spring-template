package com.ttg.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final WebClient keycloakWebclient;
    public Mono<Object> introspect(String token) {
        //TODO process token and add it to request
        //TODO add uri to keycloak
        //TODO export exception handling into a library to unify it
        return keycloakWebclient.get()
                .uri("insert uri here")
                .retrieve().bodyToMono(Object.class);
    }
}
