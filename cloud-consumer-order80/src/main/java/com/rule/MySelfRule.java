package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: MySelfRule
 * @Description: com.rule
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/28 14:32
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myrule(){
        return new RandomRule();
    }
}
