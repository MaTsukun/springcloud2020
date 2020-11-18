package com.bai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: PaymentController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/13 15:14
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private  String serverport;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getpayment(@PathVariable("id") Integer id){
        return "Hello Nacos Discovery: " + serverport + "\t id: " + id;
    }
}
