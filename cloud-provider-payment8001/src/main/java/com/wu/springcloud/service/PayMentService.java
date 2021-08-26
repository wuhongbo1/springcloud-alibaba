package com.wu.springcloud.service;

import com.wu.springcloud.entities.PayMent;

public interface PayMentService {

    int create(PayMent payMent);

    PayMent findById(Integer id);

}
