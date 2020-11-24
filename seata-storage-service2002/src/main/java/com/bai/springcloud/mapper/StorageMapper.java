package com.bai.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: StorageMapper
 * @Description: com.bai.springcloud.mapper
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:34
 */
@Mapper
public interface StorageMapper {
    void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
