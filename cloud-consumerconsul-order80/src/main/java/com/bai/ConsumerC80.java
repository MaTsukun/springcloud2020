package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: ConsumerC80
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/28 10:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerC80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerC80.class,args);
    }
}
