package com.wu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;
import com.wu.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResponseResult byResource()
    {
        return new ResponseResult(200,"按资源名称限流测试OK",new PayMent(2021,"serial001"));
    }
    public ResponseResult handleException(BlockException exception)
    {
        return new ResponseResult(444,exception.getClass().getCanonicalName()+"----服务不可用");
    }

    @GetMapping("/byResource/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler="handleException")
    public ResponseResult customerBlockHandler()
    {
        return new ResponseResult(200,"按资源名称限流测试OK",new PayMent(2021,"serial001"));
    }

}
