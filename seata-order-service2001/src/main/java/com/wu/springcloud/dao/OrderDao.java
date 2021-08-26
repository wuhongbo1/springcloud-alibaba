package com.wu.springcloud.dao;

import com.wu.springcloud.domain.CommonResult;
import com.wu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    //创建订单
    void createOrder(Order order);

    //修改订单状态
    void updateOrder(@Param("userId") Long userId,@Param("status") Integer status);

}
