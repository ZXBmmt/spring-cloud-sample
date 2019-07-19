package com.mmt.controller;

import com.mmt.client.ServerFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {
    @Autowired
    private ServerFeign serverFeign;
    //,commandProperties = {
    //            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000" )
    //    }
    @HystrixCommand(fallbackMethod = "errorHandler")
    @GetMapping("/hystrix-echo")
    public String echo() {
        long start = System.currentTimeMillis();
        String result = serverFeign.slowEcho();
        long end = System.currentTimeMillis();
        System.out.println("调用的ip为："+result+":"+(end-start));
        return result;
    }

    public String errorHandler() {
        return "系统错误!!!!";
    }
}
