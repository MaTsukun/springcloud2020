package com.bai.controller;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import com.bai.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery() {
         List<String> services = discoveryClient.getServices();
         for (String elment : services) {
             log.info("....elment:" + elment);
         }
         List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
         for(ServiceInstance elment:instances){
             log.info(elment.getServiceId()+"\t"+elment.getHost()+"\t"+elment.getPort()+"\t"+ elment.getUri());
         }
        return this.discoveryClient;
     }
     @GetMapping(value = "/payment/feign/timeout")
     public String paymentFeignTimeout(){
         try {
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         return serverPort;
     }
      @GetMapping("/payment/sp")
      public String showPort(){

        return serverPort;
      }
}
