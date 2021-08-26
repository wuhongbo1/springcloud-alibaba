package com.wu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class FallBackService implements PaymentHystrixService{
    @Override
    public String hystrixTest(Integer id) {
        return "服务器已被关闭";
    }

    @Override
    public String hystrixTestTimeOut(Integer id) {
        return "服务器已被关闭";
    }
}
