package com.bai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title: SeataMain2001
 * @Description: com.bai.springcloud
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 9:09
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataMain2001.class,args);
    }
}
