package com.bai.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bai.hander.Myhander;
import com.bai.pojo.CommonResult;
import com.bai.pojo.PayMent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: RateLimitController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/18 15:28
 */
@RestController
public class RateLimitController {

    @GetMapping(value = "/bysource")
    @SentinelResource(value = "bysource",blockHandler = "resouceHander")
    public CommonResult byResource(){
      return new CommonResult(200,"资源名称限流",new PayMent(16L,"166"));
    }
    public CommonResult resouceHander(BlockException exception){
        return new CommonResult(444,"访问失败"+exception.getClass().getCanonicalName());
    }

    @GetMapping(value = "/byurl")
    @SentinelResource(value = "byurl")
    public CommonResult byurl(){
        return new CommonResult(200,"成功访问到URL",new PayMent(20L,"999"));
    }

    @GetMapping(value = "/byhander")
    @SentinelResource(value = "byhander",blockHandlerClass = Myhander.class,blockHandler = "byhander1")
    public CommonResult byhander(){
        return new CommonResult(200,"成功访问到URL",new PayMent(21L,"999"));
    }
}
