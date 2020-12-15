package com.zc.storage.entity;

import lombok.Data;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:17
 */
@Data
public class Storage {

    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
