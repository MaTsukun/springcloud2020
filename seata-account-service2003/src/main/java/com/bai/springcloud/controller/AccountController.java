package com.bai.springcloud.controller;

import com.bai.springcloud.domain.CommonResult;
import com.bai.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Title: AccountController
 * @Description: com.bai.springcloud.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:40
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account/updateacount")
    public CommonResult updateAccount(Long userId, BigDecimal money){
       accountService.updateAccount(userId,money);
        return new CommonResult(200,"账户扣费成功");
    }

}
