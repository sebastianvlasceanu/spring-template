package com.ttg.login.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.time.Duration;

@Slf4j
@Configuration
public class KeycloakWebclient {

    @Bean
    public WebClient keycloakWebclient (WebClient.Builder cgsKeycloakWebclientBuilder) {
        return cgsKeycloakWebclientBuilder.build();
    }

    @Bean
    public WebClient.Builder cgsKeycloakWebclientBuilder () {
        HttpClient httpClient = HttpClient.create()
                .wiretap("weblcient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
                .responseTimeout(Duration.ofSeconds(3000))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }
}
