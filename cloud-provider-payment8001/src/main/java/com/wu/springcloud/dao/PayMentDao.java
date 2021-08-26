package com.wu.springcloud.dao;

import com.wu.springcloud.entities.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PayMentDao {

    int create(PayMent payMent);

    PayMent findById(Integer id);

}
