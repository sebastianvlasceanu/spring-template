package com.ttg.seed.api;

import com.ttg.seed.dto.PostBodyDto;
import com.ttg.seed.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
@Slf4j
public class TestApi {
    private final TestService testService;
    @GetMapping(path = "/get")
    public Mono<Object> testGet() {
        return testService.testGet();
    }

    @PostMapping(path = "/post")
    public Mono<Object> testPost(@RequestBody PostBodyDto postBodyDto ) {
      return testService.testPost(postBodyDto);
    }
}
