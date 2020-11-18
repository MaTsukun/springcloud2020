package com.bai.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: RouteConfig
 * @Description: com.bai.config
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/6 17:12
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customerRoute(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
          routes.route("payment_route1",
                  r ->  r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator bokeRoute(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("payment_route2",r->r.path("/boke").uri("http://www.cnblogs.com/lin530/")).build();
        return routes.build();
    }
}
