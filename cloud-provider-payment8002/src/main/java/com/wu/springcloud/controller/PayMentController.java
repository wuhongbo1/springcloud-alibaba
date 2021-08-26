package com.wu.springcloud.controller;

import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PayMentController {

    @Autowired
    private PayMentService service;
    @Value("${server.port}")
    private String serverPort;

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

    @GetMapping("/getPort")
    public String getPort(){
        return serverPort;
    }
}
