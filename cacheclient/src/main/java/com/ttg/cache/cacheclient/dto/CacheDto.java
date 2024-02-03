package com.ttg.cache.cacheclient.dto;

import lombok.Data;

@Data
public class CacheDto {
    private final String realm;
    private final String key;
    private final Object value;
    private final Long ttl;
}
