package com.bai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: StorageMain2002
 * @Description: com.bai.springcloud
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 12:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain2002.class,args);
    }
}
