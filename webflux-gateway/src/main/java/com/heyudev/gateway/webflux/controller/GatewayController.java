package com.heyudev.gateway.webflux.controller;

import org.springframework.cloud.gateway.webflux.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author supeng
 * @date 2021/06/28
 */
@RestController
@RequestMapping(value = "/")
public class GatewayController {

    String url = "http://127.0.0.1:8085/demo";

    String test1 = "/test1";
    String test2 = "/test2";

    @PostMapping(value = "/proxy")
    public Mono<ResponseEntity<Object>> proxy(ProxyExchange<Object> proxy) {
        return proxy.uri(url + test2)
                .post(responseEntity -> ResponseEntity.status(responseEntity.getStatusCode())
                        .headers(responseEntity.getHeaders())
                        .body(responseEntity.getBody()));
    }

    @GetMapping(value = "/proxy/{id}")
    public Mono<ResponseEntity<Object>> proxy(ProxyExchange<Object> proxy, @PathVariable Integer id) {
        return proxy.uri(url + test1).get();
    }
}
