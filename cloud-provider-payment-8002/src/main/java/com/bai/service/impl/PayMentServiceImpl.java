package com.bai.service.impl;

import com.bai.mapper.PayMentMapper;
import com.bai.pojo.PayMent;
import com.bai.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: PayMentServiceImpl
 * @Description: com.bai.service.impl
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:44
 */
@Service
public class PayMentServiceImpl implements PayMentService {

    @Resource
    PayMentMapper payMentMapper;

    @Override
    public int insert(PayMent payment) {
        return payMentMapper.insert(payment);
    }

    @Override
    public PayMent getPaymentById(Long id) {
        return payMentMapper.getPaymentById(id);
    }
}
