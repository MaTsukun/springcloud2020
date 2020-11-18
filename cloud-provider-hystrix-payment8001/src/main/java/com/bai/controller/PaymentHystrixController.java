package com.bai.controller;

import com.bai.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: PaymentHystrixController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/2 10:52
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentinfo_ok(id);
        log.info("*****result:"+result);
         return result;
    }
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentinfo_timeout(id);
        log.info("*****result:"+result);
        return result;
    }
    
    @GetMapping("/payment/crituit/{id}")
    public String crituitBreaker(@PathVariable("id")Integer id ){
        return paymentHystrixService.paymentCirtuitBreaker(id);
    }
}
