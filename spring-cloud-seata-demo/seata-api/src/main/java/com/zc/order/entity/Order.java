package com.zc.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 12:00
 */
@Data
@TableName("`order`")
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;
}
