package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title: OrderMain80
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/2 12:06
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderMainHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainHystrix80.class,args);
    }
}
