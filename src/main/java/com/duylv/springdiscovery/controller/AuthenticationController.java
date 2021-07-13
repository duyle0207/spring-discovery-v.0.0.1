package com.duylv.springdiscovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/demo")
    public String demo() {

        return "Hello";
    }
}
