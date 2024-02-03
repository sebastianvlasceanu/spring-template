package com.ttg.gateway.config;

import com.ttg.gateway.dto.ServiceRegistryElementDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ServiceRegistryConfig {
    @Bean
    public Map<String, ServiceRegistryElementDto> serviceRegistryBean() {
        return new HashMap<>();
    }
}
