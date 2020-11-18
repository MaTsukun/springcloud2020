package com.bai.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: AppConfig
 * @Description: com.bai.config
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/28 10:05
 */
@Configuration
public class AppConfig {

    /**
     * 注入restTemplate，请用请求rest接口
     * @return
     */
    @Bean
    // 标注此注解后，RestTemplate就具有了客户端负载均衡能力
    // 负载均衡技术依赖于的是Ribbon组件~
    // RestTemplate都塞入一个loadBalancerInterceptor 让其具备有负载均衡的能力
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
