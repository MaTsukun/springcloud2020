package com.bai.controller;

import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Title: PaymentController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/19 11:26
 */
@RestController
public class PaymentController { @Value("${server.port}")
private  String serverPort;

    public static HashMap<Long, PayMent > map = new HashMap<>();
    static {
        map.put(1L,new PayMent(1L,"1111"));
        map.put(2L,new PayMent(2L,"2222"));
        map.put(3L,new PayMent(3L,"3333"));
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<PayMent> paymentSQL(@PathVariable("id") Long id) {
        PayMent payment = map.get(id);
        CommonResult<PayMent> result = new CommonResult<>(200,"from mysql,serverPort: " + serverPort,payment);
        return result;
    }

}
