package com.ttg.cache.cacheserver.dto;

import lombok.Data;

@Data
public class TtlDto {
    private final String key;
    private final String realm;
    private final Long ttl;
}
