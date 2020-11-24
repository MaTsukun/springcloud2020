package com.bai.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Title: Account
 * @Description: com.bai.springcloud.domain
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal  residue;
}
