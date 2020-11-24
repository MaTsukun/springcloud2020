package com.bai.springcloud.controller;

import com.bai.springcloud.domain.CommonResult;
import com.bai.springcloud.domain.Order;
import com.bai.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: OrderController
 * @Description: com.bai.springcloud.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 9:44
 */
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
     orderService.create(order);
       return new CommonResult(200,"订单创建成功",order);
    }
}
