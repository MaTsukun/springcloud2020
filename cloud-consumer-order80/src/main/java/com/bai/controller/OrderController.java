package com.bai.controller;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Title: OrderController
 * @Description: org.example.Controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/21 12:08
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/insert")
    public CommonResult<PayMent> insert(PayMent payment){
        log.info("====== 请求插入：" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<PayMent> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<PayMent> getPayment2(@PathVariable("id") Long id){
       ResponseEntity<CommonResult> entity= restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
       if(entity.getStatusCode().is2xxSuccessful()){
           return entity.getBody();
       }else{
           return new CommonResult<PayMent>(444,"编码错误");
       }
    }
    @PostMapping("/consumer/payment/insert2")
    public CommonResult<PayMent> insert2(PayMent payment){
        log.info("====== 请求插入：" + payment);
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/insert", payment, CommonResult.class).getBody();
    }
}
