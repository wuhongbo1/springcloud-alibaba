package com.wu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   //支持Nacs动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String config;

    @GetMapping("/config/info")
    public String getConfig(){
        return config;
    }
}
