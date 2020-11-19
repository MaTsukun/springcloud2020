package com.bai.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: ApplicationConfig
 * @Description: com.bai.config
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 11:55
 */
@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced
    public RestTemplate gettemple(){
        return new RestTemplate();
    }
}
