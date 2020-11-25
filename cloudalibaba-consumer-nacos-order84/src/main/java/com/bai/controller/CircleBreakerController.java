package com.bai.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import com.bai.service.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Title: CircleBreakerController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 11:39
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static  final  String SERVICE_URL = "http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback ="handlerFallback")
    @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler")
    public CommonResult<PayMent> fallback(@PathVariable Long id) {
        CommonResult<PayMent> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class,id);
        //设置特定参数报错，进行降级
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }else if(result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return  result;
    }
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
        PayMent payment = new PayMent(id,"null");
        return new CommonResult(444,"异常handlerFallback，exception内容： " + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        PayMent payment = new PayMent(id,"null");
        return new CommonResult(444,"blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }

    @Resource
    private PaymentFeign paymentFeign;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<PayMent> paymentSQLC(@PathVariable("id") Long id){
        return paymentFeign.paymentSQL(id);
    }
}
