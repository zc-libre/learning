package com.zc.transaction.pojo;

import lombok.Data;

/**
 * @author zhao.cheng
 * @date 2020/12/16 16:38
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String db;
}
