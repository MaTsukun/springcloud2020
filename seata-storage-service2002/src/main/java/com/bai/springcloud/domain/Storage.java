package com.bai.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: Storage
 * @Description: com.bai.springcloud.domain
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/24 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
