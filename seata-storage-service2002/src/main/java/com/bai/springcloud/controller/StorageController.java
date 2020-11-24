package com.bai.springcloud.controller;

import com.bai.springcloud.domain.CommonResult;
import com.bai.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: StorageController
 * @Description: com.bai.springcloud.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:25
 */
@RestController
public class StorageController {

     @Resource
     private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存扣减完成");
    }

}
