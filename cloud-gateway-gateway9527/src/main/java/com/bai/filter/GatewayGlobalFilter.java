package com.bai.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Title: GatewayGlobalFiflter
 * @Description: com.bai.fifter
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/9 10:58
 */
@Component
@Slf4j
public class GatewayGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***time is :"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){

            log.info("没有用户名，出现错误：o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /*
    设置过滤器优先级，越小优先级越大
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
