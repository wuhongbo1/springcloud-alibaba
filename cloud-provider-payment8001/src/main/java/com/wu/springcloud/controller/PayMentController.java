package com.wu.springcloud.controller;

import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PayMentController {

    @Autowired
    private PayMentService service;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discovery;

    @PostMapping("/createPayment")
    public ResponseResult createPayment(@RequestBody PayMent payMent){
        int result = service.create(payMent);
        if (result > 0){
            return new ResponseResult(200,"插入成功,serverPort"+serverPort);
        }else{
            return new ResponseResult(400,"插入失败");
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id){
        PayMent payMent = service.findById(id);
        if (payMent  != null){
            return new ResponseResult(200,"查询成功,serverPort"+serverPort,payMent);
        }else{
            return new ResponseResult(400,"查询失败");
        }
    }

    @GetMapping("/getDiscovery")
    public DiscoveryClient getDiscovery(){
        List<String> services = discovery.getServices();
        for (String s : services) {
            System.out.println(s + "--");
        }
        List<ServiceInstance> instances = discovery.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("client:"+instance.getServiceId()+"--"+instance.getHost()+"--"+instance.getPort()+"--"+instance.getUri());
        }
        return this.discovery;
    }

    @GetMapping("/getPort")
    public String getPort(){
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
