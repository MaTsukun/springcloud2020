package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: Payment9004
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 11:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9004.class,args);
    }
}
