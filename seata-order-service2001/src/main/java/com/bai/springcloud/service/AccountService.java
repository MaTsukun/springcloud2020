package com.bai.springcloud.service;

import com.bai.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Title: AccountService
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 11:12
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/updateacount")
    public CommonResult updateAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
