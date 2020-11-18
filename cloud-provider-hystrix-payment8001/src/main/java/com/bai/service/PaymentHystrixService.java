package com.bai.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Title: PaymentHystrixService
 * @Description: com.bai.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/2 10:46
 */
@Service
public class PaymentHystrixService {
    public String paymentinfo_ok(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentinfo_ok,id:"+id+"\t"+"成功！！！！";
    }
    @HystrixCommand(fallbackMethod = "paymentinfo_Timeouthander",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
   public String paymentinfo_timeout(Integer id){
        int timenum=5;
       try {
           TimeUnit.SECONDS.sleep(timenum);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return "线程池:"+Thread.currentThread().getName()+"paymentinfo_timeout,id:"+id+"\t"+"失败！！！！耗时(秒):"+timenum;
   }
   public String paymentinfo_Timeouthander(@PathVariable("id") Integer id){
       return "线程池:"+Thread.currentThread().getName()+"系统繁忙，请稍后重试,id:"+id+"\t"+"失败！！！！o(╥﹏╥)o";
   }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCirtuitBreaker(@PathVariable("id")Integer id){
      if(id<0){
          throw new RuntimeException("****id不能为负数");
      }
      String randomNum= IdUtil.simpleUUID();

      return Thread.currentThread().getName()+"\t"+"调用成功，编号"+randomNum;

    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后重试，o(╥﹏╥)o+"+id;
    }

}
