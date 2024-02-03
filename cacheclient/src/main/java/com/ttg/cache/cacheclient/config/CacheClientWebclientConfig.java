package com.ttg.cache.cacheclient.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
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
public class CacheClientWebclientConfig {
    private static final String BASE_URL = "...";
    //TODO export base url to yaml
    @Bean
    public WebClient cacheClientWebclient(WebClient.Builder cgsCacheClientWebclientBuilder) {
        return cgsCacheClientWebclientBuilder.baseUrl(BASE_URL).build();
    }

    @Bean
    public WebClient.Builder cgsCacheClientWebclientBuilder () {
        HttpClient httpClient = HttpClient.create()
                .wiretap("webclient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
                .responseTimeout(Duration.ofSeconds(3000))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }
}
