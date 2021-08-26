package com.wu.springcloud.controller;

import com.wu.springcloud.domain.CommonResult;
import com.wu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService service;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        service.update(productId,count);
        return new CommonResult(200,"库存更新成功");
    }

}
