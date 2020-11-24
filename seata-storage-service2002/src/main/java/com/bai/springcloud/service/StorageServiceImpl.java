package com.bai.springcloud.service;

import com.bai.springcloud.mapper.StorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: StorageServiceImpl
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:35
 */
@Service
public class StorageServiceImpl implements StorageService{

    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
         storageMapper.decrease(productId,count);
    }
}
