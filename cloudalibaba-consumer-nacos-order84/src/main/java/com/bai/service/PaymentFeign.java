package com.bai.service;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Title: PaymentFeign
 * @Description: com.bai.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 12:23
 */
@FeignClient(value ="nacos-payment-provider",fallback = PaymentFallback.class)
public interface PaymentFeign {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<PayMent> paymentSQL(@PathVariable("id") Long id);

    }
