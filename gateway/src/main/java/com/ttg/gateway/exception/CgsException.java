package com.ttg.gateway.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CgsException  extends RuntimeException {
    private Integer statusCode;
    private String message;

}
