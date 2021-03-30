package com.libre.security.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhao.cheng
 * @date 2021/3/3 16:33
 */
@Data
public class User {
    private Long id;
    private String name;
    private LocalDateTime dateTime;
}
