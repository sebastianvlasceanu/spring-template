package com.ttg.cache.cacheserver.service;

import com.ttg.cache.cacheserver.dto.CacheDto;
import com.ttg.cache.cacheserver.dto.TtlDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CacheService {
    public Mono<Object> contains(String key, String realm) {
        //TODO implement contains action
        //it must check that an non-null object with the specified key exists in the specified realm
        return Mono.empty();
    }

    public Mono<Object> getObject(String key, String realm) {
        //TODO implement get action
        //it must retrieve either null (404) or the value stored for the key and realm and must reset ttl
        return Mono.empty();
    }

    public Mono<Object> putObject(CacheDto cacheDto) {
        //TODO implement put action
        //must store the provided object with the key and realm and set ttl
        return Mono.empty();
    }

    public Mono<Object> resetTtl(TtlDto ttlDto) {
        //TODO reset ttl for the specified key and realm if non-null or return error (cannot process)
        return Mono.empty();
    }

    public Mono<Object> getTtl(String key, String realm) {
        //TODO implement get ttl action
        //retrieve ttl for the specified key and realm if non null or return 404
        return Mono.empty();
    }
}
