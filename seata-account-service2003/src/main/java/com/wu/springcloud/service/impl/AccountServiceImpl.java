package com.wu.springcloud.service.impl;

import com.wu.springcloud.dao.AccountDao;
import com.wu.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     * 修改金额
     * @param userId    用户id
     * @param money     消费金额
     */
    @Override
    public void update(Long userId, BigDecimal money) {
        accountDao.update(userId, money);
    }
}
