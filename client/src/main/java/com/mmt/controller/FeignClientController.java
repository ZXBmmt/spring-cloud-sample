package com.mmt.controller;

import com.mmt.client.ServerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

    @Autowired
    private ServerFeign serverFeign;

    @GetMapping("/feign-echo")
    public String echo() {
        String result = serverFeign.echo();
        System.out.println("调用的ip为："+result);
        return result;
    }
}
