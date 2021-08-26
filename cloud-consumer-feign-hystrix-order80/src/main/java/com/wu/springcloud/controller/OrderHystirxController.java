package com.wu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wu.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payMentTest/{id}")
    public String payMentTest(@PathVariable("id") Integer id){
        String result = paymentHystrixService.hystrixTest(id);
        return result;
    }

    @GetMapping("/consumer/payMentTestTimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod")
    public String payMentTestTimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.hystrixTestTimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
}
