package com.wu.springcloud.controller;

import com.wu.springcloud.domain.CommonResult;
import com.wu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountService service;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
            service.update(userId, money);
            return new CommonResult(200,"金额修改成功");
    }

}
