package com.ttg.login.dto;

import lombok.Data;

@Data
public class RefreshRequestDto {
    private final String token;
    private final String refreshToken;
}
