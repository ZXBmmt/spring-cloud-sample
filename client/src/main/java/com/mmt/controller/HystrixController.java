package com.mmt.controller;

import com.mmt.client.ServerFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {
    @Autowired
    private ServerFeign serverFeign;

    @HystrixCommand(fallbackMethod = "errorHandler")
    @GetMapping("/hystrix-echo")
    public String echo() {
        String result = serverFeign.slowEcho();
        System.out.printf("调用的ip为："+result);
        return result;
    }

    public String errorHandler() {
        return "系统错误!!!!";
    }
}
