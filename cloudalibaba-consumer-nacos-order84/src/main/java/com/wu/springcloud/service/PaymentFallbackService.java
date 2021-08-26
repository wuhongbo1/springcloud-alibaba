package com.wu.springcloud.service;

import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public ResponseResult paymentSQL(Integer id) {
        return new ResponseResult(400,"服务降级",new PayMent(1,"ERROR"));
    }
}
