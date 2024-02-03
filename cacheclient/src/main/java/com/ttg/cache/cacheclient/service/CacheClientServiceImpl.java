package com.ttg.cache.cacheclient.service;

import com.ttg.cache.cacheclient.dto.CacheDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CacheClientServiceImpl implements CacheClientService {
    private WebClient cacheClientWebclient;
    private static final String CONTAINS_PATH = "/cache/contains";
    private static final String GET_PATH = "/cache/get";
    private static final String PUT_PATH = "/cache/putObject";




    @Override
    public Mono<Boolean> contains(String key, String realm) {
        return cacheClientWebclient.get()
                .uri(CONTAINS_PATH + "?key=" + key + ";realm=" + realm)
                .retrieve().bodyToMono(Boolean.class);
    }

    @Override
    public Mono<Object> get(String key, String realm) {
        return cacheClientWebclient.get()
                .uri(GET_PATH + "?key=" + key + ";realm=" + realm)
                .retrieve().bodyToMono(Object.class);
    }

    @Override
    public Mono<Object> put(CacheDto cacheDto) {
        return cacheClientWebclient.post()
                .uri(PUT_PATH)
                .bodyValue(cacheDto)
                .retrieve().bodyToMono(Object.class);
    }

}
