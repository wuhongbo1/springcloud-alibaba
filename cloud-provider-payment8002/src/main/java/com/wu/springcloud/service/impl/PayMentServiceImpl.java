package com.wu.springcloud.service.impl;

import com.wu.springcloud.dao.PayMentDao;
import com.wu.springcloud.entities.PayMent;
import com.wu.springcloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayMentServiceImpl implements PayMentService {

    @Autowired
    private PayMentDao payMentDao;

    @Override
    public int create(PayMent payMent) {
        int i = payMentDao.create(payMent);
        return i;
    }

    @Override
    public PayMent findById(Integer id) {
        return payMentDao.findById(id);
    }
}
