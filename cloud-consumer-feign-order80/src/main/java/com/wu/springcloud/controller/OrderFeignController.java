package com.wu.springcloud.controller;

import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/findById/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id){
        return paymentFeignService.findById(id);
    }

}
