package com.bai.controller;

import com.bai.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: OrderController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/2 12:07
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id")Integer id){
        String result = paymentHystrixService.payment_ok(id);
        return result;
    }
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentinfo_Timeouthander",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    public String payment_timeout(@PathVariable("id")Integer id){
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }
    public String paymentinfo_Timeouthander(@PathVariable("id") Integer id){
        return "线程池:"+Thread.currentThread().getName()+"我是消费者，系统繁忙，请稍后重试,id:"+id+"\t"+"失败！！！！o(╥﹏╥)o";
    }
}
