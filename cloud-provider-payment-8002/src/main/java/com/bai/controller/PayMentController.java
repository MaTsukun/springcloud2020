package com.bai.controller;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import com.bai.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Title: PayMentController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:46
 */

@RestController
@Slf4j
public class PayMentController {
    @Resource
    private PayMentService PayMentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody PayMent payment) {
        int result = PayMentService.insert(payment);
        log.info("====== 插入结果：" + result);
        if(result > 0) {
            return new CommonResult(200, "插入数据成功，服务端口：" + serverPort,result);
        }else {
            return new CommonResult(500, "插入数据失败");
        }

    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        PayMent result = PayMentService.getPaymentById(id);

        log.info("====== 查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功，服务端口：" + serverPort, result);
        } else {
            return new CommonResult(500, "查询失败");
        }
    }
    @GetMapping("/payment/sp")
    public String showPort(){

        return serverPort;
    }


}
