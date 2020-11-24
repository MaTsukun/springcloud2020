package com.bai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: AccountMain2003
 * @Description: com.bai.springcloud
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 12:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountMain2003.class,args);
    }
}
