package com.lsy.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class TestController {

    public record People(String name,Integer age){}
    @RequestMapping("/test")
    public String test() {
        return "Hello, Spring Boot!";
    }

}
