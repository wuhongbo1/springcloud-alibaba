package com.wu.springcloud.controller;

import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discovery;

    @PostMapping("/create")
    public ResponseResult create(@RequestBody PayMent payMent){
        return restTemplate.postForObject(PAYMENT_URL + "/createPayment",payMent,ResponseResult.class);
    }

    @GetMapping("/findById/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL + "/findById/" + id,ResponseResult.class);
    }

    @GetMapping("/getParameterIb")
    public String getParameterIb(){
        List<ServiceInstance> instances = discovery.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/getPort",String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
