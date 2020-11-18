package com.bai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: CommonResult
 * @Description: com.bai.pojo
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/10/26 15:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
