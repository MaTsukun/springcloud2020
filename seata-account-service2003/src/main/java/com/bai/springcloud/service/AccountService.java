package com.bai.springcloud.service;

import java.math.BigDecimal;

/**
 * @Title: AccountService
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:43
 */
public interface AccountService {
    void updateAccount(Long userId, BigDecimal money);
}
