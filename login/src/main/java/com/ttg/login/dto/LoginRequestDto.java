package com.ttg.login.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private final String username;
    private final String password;
}
