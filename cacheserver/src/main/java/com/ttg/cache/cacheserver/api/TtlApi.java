package com.ttg.cache.cacheserver.api;

import com.ttg.cache.cacheserver.dto.CacheDto;
import com.ttg.cache.cacheserver.dto.TtlDto;
import com.ttg.cache.cacheserver.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ttl")
@AllArgsConstructor
public class TtlApi {
    private CacheService cacheService;
    @GetMapping(path = "/get")
    public Mono<Object> cacheContains(@RequestParam String key, @RequestParam String realm) {
        return cacheService.getTtl(key, realm);
    }

    @PostMapping(path = "/reset")
    public Mono<Object> putObject(@RequestBody TtlDto ttlDto) {
        return cacheService.resetTtl(ttlDto);
    }
}
