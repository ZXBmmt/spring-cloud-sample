package com.mmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class EchoContorller {

    @GetMapping("/echo")
    public String echo() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }
}
