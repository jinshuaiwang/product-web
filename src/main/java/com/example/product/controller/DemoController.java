package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 11:33 AM
 * Email: jinshuaiwang@126.com
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "hello " + name;
    }
}
