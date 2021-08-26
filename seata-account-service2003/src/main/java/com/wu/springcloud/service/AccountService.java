package com.wu.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {

    void update(Long userId, BigDecimal money);

}
