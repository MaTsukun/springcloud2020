package com.bai.mapper;

import com.bai.pojo.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: PayMentMapper.xml
 * @Description: com.bai.mapper
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:42
 */
@Mapper
public interface PayMentMapper {
    public  int insert(PayMent payment);

    public PayMent getPaymentById(@Param("id") Long id);
}
