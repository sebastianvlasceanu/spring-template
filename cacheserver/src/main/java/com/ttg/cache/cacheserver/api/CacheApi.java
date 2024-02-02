package com.ttg.cache.cacheserver.api;

import com.ttg.cache.cacheserver.dto.CacheDto;
import com.ttg.cache.cacheserver.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class CacheApi {
    private CacheService cacheService;
    @GetMapping(path = "/contains")
    public Mono<Object> cacheContains(@RequestParam String key, @RequestParam String realm) {
        return cacheService.contains(key, realm);
    }

    @GetMapping(path = "/get")
    public Mono<Object> getObject(@RequestParam String key, @RequestParam String realm) {
        return cacheService.getObject(key, realm);
    }

    @PostMapping(path = "/putObject")
    public Mono<Object> putObject(@RequestBody CacheDto cacheDto) {
        return cacheService.putObject(cacheDto);
    }
}
