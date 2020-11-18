package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Title: PayMent8001
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:34
 */
@EnableEurekaClient
@SpringBootApplication
public class PayMent8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class,args);
    }

}
