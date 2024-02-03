package com.ttg.gateway.healthcheck;

import com.ttg.gateway.dto.ServiceRegistryElementDto;
import com.ttg.gateway.exception.CgsException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CustomHealthCheck {

    private final Map<String, ServiceRegistryElementDto> serviceRegistryBean;

    @PostMapping(path = "/register")
    public Mono<Object> register(@RequestBody ServiceRegistryElementDto service) {

        ServiceRegistryElementDto existentService = serviceRegistryBean.get(service.getServiceName());
        if (existentService == null) {
            service.setReplicas(1);
            serviceRegistryBean.put(service.getServiceName(), service);
        } else {
            existentService.setReplicas(existentService.getReplicas() + 1);
        }

        return Mono.empty();
    }

    @PostMapping(path = "/unregister")
    public Mono<Object> unregister(@RequestParam String serviceName) {
        ServiceRegistryElementDto existentService = serviceRegistryBean.get(serviceName);
        if (existentService == null) {
            return Mono.error(new CgsException(404, "No Service found"));
        } else if (existentService.getReplicas() > 0){
            existentService.setReplicas(existentService.getReplicas() - 1);
        } else {
            serviceRegistryBean.remove(serviceName);
        }
        return Mono.empty();
    }
}
