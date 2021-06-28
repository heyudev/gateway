package com.heyudev.gateway.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author supeng
 * @date 2021/06/28
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/test1")
    public Object test1() {
        return new HashMap<>();
    }

    @PostMapping(value = "/test2")
    public Map<String, String> test2() {
        Map<String, String> map = new HashMap<>();
        map.put("ok", "?");
        return map;
    }
}
