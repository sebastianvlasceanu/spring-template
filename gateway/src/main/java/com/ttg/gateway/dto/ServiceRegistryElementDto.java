package com.ttg.gateway.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServiceRegistryElementDto {
    private String serviceName;
    private List<SecurityMetadataDto> securityMetadatas;
    private Integer replicas;
}
