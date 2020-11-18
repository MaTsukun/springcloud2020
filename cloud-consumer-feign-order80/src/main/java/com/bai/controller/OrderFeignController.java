package com.bai.controller;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import com.bai.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: OrderFeignController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/29 10:18
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<PayMent> getPaymentId(@PathVariable("id") long id){
         return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String feigntimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
