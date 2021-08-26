package com.wu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.wu.springcloud.dao"})
public class MyBatisConfig {
}
