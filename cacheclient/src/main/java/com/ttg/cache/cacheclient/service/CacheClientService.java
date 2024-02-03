package com.ttg.cache.cacheclient.service;

import com.ttg.cache.cacheclient.dto.CacheDto;
import reactor.core.publisher.Mono;

public interface CacheClientService {
    Mono<Boolean> contains(String key, String realm);

    Mono<Object> get(String key, String realm);

    Mono<Object> put(CacheDto cacheDto);
}
