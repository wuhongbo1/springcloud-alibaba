package com.wu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.entities.ResponseResult;

public class CustomerBlockHandler {

    public static ResponseResult handleException(BlockException exception){
        return new ResponseResult(400,"自定义的CustomerBlockHandler",new PayMent(2021,"002"));
    }

}
