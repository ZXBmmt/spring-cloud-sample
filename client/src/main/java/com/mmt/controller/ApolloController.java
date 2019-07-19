package com.mmt.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApolloController {

    @Value("${apollo.test.properties.valueEnv}")
    private String env;

    @GetMapping("/apollo/env-echo")
    public String echo() {
        return env;
    }
}
