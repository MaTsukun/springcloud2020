package com.bai.service;

import org.springframework.stereotype.Component;

/**
 * @Title: PaymentFallback
 * @Description: com.bai.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/4 16:42
 */
@Component
public class PaymentFallback implements PaymentHystrixService
{
    @Override
    public String payment_ok(Integer id) {
        return "服务失败了，o(╥﹏╥)o";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "服务超时或者运行报错，o(╥﹏╥)o";
    }
}
