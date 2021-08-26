package com.wu.springcloud.controller;

import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, PayMent> hashMap = new HashMap();
    static
    {
        hashMap.put(1,new PayMent(1,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2,new PayMent(2,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3,new PayMent(3,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public ResponseResult<PayMent> paymentSQL(@PathVariable("id") Integer id)
    {
        PayMent payment = hashMap.get(id);
        ResponseResult<PayMent> result = new ResponseResult(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }

}

