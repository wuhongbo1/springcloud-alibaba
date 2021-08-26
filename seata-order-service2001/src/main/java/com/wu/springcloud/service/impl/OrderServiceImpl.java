package com.wu.springcloud.service.impl;

import com.wu.springcloud.dao.OrderDao;
import com.wu.springcloud.domain.Order;
import com.wu.springcloud.service.AccountService;
import com.wu.springcloud.service.OrderService;
import com.wu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //创建订单
        orderDao.createOrder(order);
        //修改库存
        storageService.decrease(order.getProductId(),order.getCount());
        //修改金额
        accountService.decrease(order.getUserId(),order.getMoney());

        //修改订单状态
        orderDao.updateOrder(order.getUserId(),0);

    }
}
