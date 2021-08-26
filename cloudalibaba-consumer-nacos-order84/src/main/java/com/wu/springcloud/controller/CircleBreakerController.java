package com.wu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String url;
    @Resource
    private PaymentService service;

    @GetMapping("/consumer/paymentSQL/{id}")
    @SentinelResource(value = "fallback",
                        fallback="handlerFallback",
                        blockHandler = "blockHandler")
    public ResponseResult getPayment(@PathVariable("id") Integer id){
        ResponseResult result = restTemplate.getForObject(url + "/paymentSQL/" + id, ResponseResult.class, id);

        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException---非法参数异常");
        }else if (result.getData() == null){
            throw new NullPointerException("NullPointerException---空指针异常");
        }
        return result;
    }

    public ResponseResult handlerFallback(@PathVariable  Integer id,Throwable e) {
        PayMent payment = new PayMent(id,"null");
        return new ResponseResult<>(444,"fallback,无此流水,exception  "+e.getMessage(),payment);
    }
    public ResponseResult blockHandler(@PathVariable  Integer id, BlockException blockException) {
        PayMent payment = new PayMent(id,"null");
        return new ResponseResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @GetMapping("/consumer/getSql/{id}")
    public ResponseResult paymentSql(@PathVariable  Integer id){
        return service.paymentSQL(id);
    }
}
