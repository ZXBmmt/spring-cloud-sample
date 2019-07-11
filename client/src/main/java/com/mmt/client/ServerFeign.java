package com.mmt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-cloud-eureka-server-sample")
public interface ServerFeign {

    @RequestMapping("/echo")
    public String echo();
}
