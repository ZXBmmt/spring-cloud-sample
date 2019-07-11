package com.mmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest-template-echo")
    public String echo() {
        String echoUrl = "http://spring-cloud-eureka-server-sample/echo";
        String result = restTemplate.getForObject(echoUrl, String.class);
        System.out.printf("调用的ip为："+result);
        return result;
    }
}
