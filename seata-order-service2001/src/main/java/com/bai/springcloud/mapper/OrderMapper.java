package com.bai.springcloud.mapper;

import com.bai.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: OrderMapper
 * @Description: com.bai.springcloud.mapper
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 9:33
 */
@Mapper
public interface OrderMapper {

    void create(Order order);

    void update(@Param("userId")long userId,@Param("status")Integer status);
}
