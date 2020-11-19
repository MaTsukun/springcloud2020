package com.bai.service;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import org.springframework.stereotype.Component;

/**
 * @Title: PaymentFallback
 * @Description: com.bai.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 12:24
 */
@Component
public class PaymentFallback implements PaymentFeign{
    @Override
    public CommonResult<PayMent> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new PayMent(id,"ErrorSerial"));
    }
}
