package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title: Consumer84
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 11:36
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Consumer84 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer84.class,args);
    }
}
