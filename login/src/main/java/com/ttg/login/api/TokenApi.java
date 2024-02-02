package com.ttg.login.api;

import com.ttg.login.service.TokenService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/token")
public class TokenApi {
    private TokenService tokenService;
    @GetMapping(path = "/introspect")
    public Mono<Object> introspect(@RequestParam String token) {
        return tokenService.introspect(token);
    }

}
