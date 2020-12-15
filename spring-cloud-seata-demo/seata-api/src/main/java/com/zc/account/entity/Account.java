package com.zc.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 13:50
 */
@Data
public class Account {

    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;

    @TableField(exist = false)
    private Integer count;
}
