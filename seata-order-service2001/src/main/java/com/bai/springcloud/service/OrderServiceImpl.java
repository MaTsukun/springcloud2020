package com.bai.springcloud.service;

import com.bai.springcloud.domain.Order;
import com.bai.springcloud.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: OrderServiceImpl
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 9:54
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name="abc-create-order",rollbackFor = Exception.class)
    public void create(Order order){
        //1.创建订单
        log.info("开始创建订单");
        orderMapper.create(order);
        //2.减少库存
        log.info("查询库存并且进行更改");
        storageService.decrease(order.getProductId(),order.getCount());
        //3.扣除费用
        log.info("查询余额并扣除费用");
        accountService.updateAccount(order.getUserId(),order.getMoney());
        //4.修改状态
        log.info("更改订单状态");
        orderMapper.update(order.getUserId(),0);
        log.info("订单结束，O(∩_∩)O哈哈~");
    }
}
