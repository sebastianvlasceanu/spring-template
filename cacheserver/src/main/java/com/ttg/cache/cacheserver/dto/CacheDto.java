package com.ttg.cache.cacheserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CacheDto {
    private final String realm;
    private final String key;
    private final Object value;
    private final Long ttl;
}
