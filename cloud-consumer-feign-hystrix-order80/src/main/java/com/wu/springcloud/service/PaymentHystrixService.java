package com.wu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = FallBackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payMentTest/{id}")
    String hystrixTest(Integer id);

    @GetMapping("/payMentTestTimeOut/{id}")
    String hystrixTestTimeOut(Integer id);


}
