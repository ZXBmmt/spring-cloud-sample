package com.mmt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class SlowEchoController {

    @GetMapping("/slow-echo")
    public String echo() throws UnknownHostException {
        if(ThreadLocalRandom.current().nextDouble()>0.5){
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
        }
        return InetAddress.getLocalHost().getHostAddress();
    }
}
