package com.wu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentInfo")
    public String paymentInfo(){
        return "springcloud with consul: "+serverPort+"----"+ UUID.randomUUID().toString();
    }
}
