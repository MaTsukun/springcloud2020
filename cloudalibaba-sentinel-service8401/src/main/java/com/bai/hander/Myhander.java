package com.bai.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bai.pojo.CommonResult;

/**
 * @Title: Myhander
 * @Description: com.bai.hander
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/18 16:36
 */
public class Myhander {
    public static CommonResult byhander1(BlockException exception){
        return new CommonResult(400,"访问失败了"+exception.getClass().getCanonicalName()+"这里是hander1");
    }
    public static CommonResult byhander2(BlockException exception){
        return new CommonResult(400,"访问失败了"+exception.getClass().getCanonicalName()+"这里是hander2");
    }
}
