package com.bai.springcloud.service;

import com.bai.springcloud.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Title: AccountServiceImpl
 * @Description: com.bai.springcloud.service
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:43
 */
@Service
public class AccountServiceImpl implements AccountService{
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void updateAccount(Long userId, BigDecimal money) {
        LOGGER.info("----> account-service中扣减用户余额开始");
       /* try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
         accountMapper.updateAccount(userId,money);
        LOGGER.info("----> account-service中扣减用户余额开始");
    }
}
