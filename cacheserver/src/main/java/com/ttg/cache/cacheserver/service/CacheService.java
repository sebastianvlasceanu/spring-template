package com.ttg.cache.cacheserver.service;

import com.ttg.cache.cacheserver.dto.CacheDto;
import com.ttg.cache.cacheserver.dto.TtlDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CacheService {
    public Mono<Object> contains(String key, String realm) {
        return Mono.empty();
    }

    public Mono<Object> getObject(String key, String realm) {
        return Mono.empty();
    }

    public Mono<Object> putObject(CacheDto cacheDto) {
        return Mono.empty();
    }

    public Mono<Object> resetTtl(TtlDto ttlDto) {
        return Mono.empty();
    }

    public Mono<Object> getTtl(String key, String realm) {
        return Mono.empty();
    }
}
