package com.wu.springcloud.service;

import com.wu.springcloud.entities.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/findById/{id}")
    ResponseResult findById(@PathVariable("id") Integer id);

}
