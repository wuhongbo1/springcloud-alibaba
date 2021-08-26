package com.wu.springcloud.controller;

import com.wu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payMentTest/{id}")
    public String payMentTest(@PathVariable("id") Integer id){
        String result = paymentService.hystrixTest(id);
        return result;
    }

    @GetMapping("/payMentTestTimeOut/{id}")
    public String payMentTestTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.hystrixTestTimeOut(id);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }
}
