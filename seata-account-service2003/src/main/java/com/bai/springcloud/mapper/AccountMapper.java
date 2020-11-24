package com.bai.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Title: AccountMapper
 * @Description: com.bai.springcloud.mapper
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:44
 */
@Mapper
public interface AccountMapper {

    void updateAccount(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
