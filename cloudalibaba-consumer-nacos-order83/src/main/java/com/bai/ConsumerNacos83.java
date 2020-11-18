package com.bai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: ConsumerNacos83
 * @Description: com.bai
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/13 15:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacos83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacos83.class,args);
    }
}
