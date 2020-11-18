package com.bai.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Title: FeignConfig
 * @Description: com.bai.config
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/29 11:48
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignloggerlevel(){
        return Logger.Level.FULL;
    }
}
