package com.ttg.login.api;

import com.ttg.login.dto.LoginRequestDto;
import com.ttg.login.dto.RefreshRequestDto;
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

    @PostMapping(path = "/login")
    public Mono<Object> login(@RequestBody LoginRequestDto loginRequestDto) {
        return tokenService.login(loginRequestDto);
    }

    @PostMapping(path = "/refresh")
    public Mono<Object> refresh(@RequestBody RefreshRequestDto refreshRequestDto) {
        return tokenService.refresh(refreshRequestDto);
    }

}
