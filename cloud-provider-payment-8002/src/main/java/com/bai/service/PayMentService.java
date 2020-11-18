package com.bai.service;

import com.bai.pojo.PayMent;

/**
 * @Title: PayMentService
 * @Description: com.bai.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:43
 */
public interface PayMentService {
    public int insert(PayMent payment);

    public PayMent getPaymentById(Long id);

}
