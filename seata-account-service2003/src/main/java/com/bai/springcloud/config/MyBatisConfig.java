package com.bai.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: MyBatisConfig
 * @Description: com.bai.springcloud.config
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 11:09
 */
@Configuration
@MapperScan({"com.bai.springcloud.mapper"})
public class MyBatisConfig  {
}
