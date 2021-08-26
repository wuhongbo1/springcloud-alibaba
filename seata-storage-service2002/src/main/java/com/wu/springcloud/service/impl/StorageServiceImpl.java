package com.wu.springcloud.service.impl;

import com.wu.springcloud.dao.StorageDao;
import com.wu.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 修改库存
     * @param productId 库存id
     * @param count     数量
     */
    @Override
    public void update(Long productId,Integer count) {
        storageDao.update(productId,count);
    }
}
