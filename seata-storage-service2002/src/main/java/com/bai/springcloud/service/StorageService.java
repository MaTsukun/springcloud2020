package com.bai.springcloud.service;

/**
 * @Title: StorageService
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:34
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
