package com.ttg.cache.cacheserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheServerApplication {
    //TODO mus timplement ttl mechanism

    public static void main(String[] args) {
        SpringApplication.run(CacheServerApplication.class, args);
    }

}
