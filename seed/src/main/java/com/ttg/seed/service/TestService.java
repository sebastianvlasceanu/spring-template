package com.ttg.seed.service;

import com.ttg.seed.dto.PostBodyDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TestService {
    public Mono<Object> testGet() {
        return Mono.empty();
    }

    public Mono<Object> testPost(PostBodyDto dto) {
        return Mono.just(dto);
    }
}
