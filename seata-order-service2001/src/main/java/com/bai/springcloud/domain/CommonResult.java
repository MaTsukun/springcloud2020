package com.bai.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: CommonResult
 * @Description: com.bai.springcloud.domain
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 9:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}