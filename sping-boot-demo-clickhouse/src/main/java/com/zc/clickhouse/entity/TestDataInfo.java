package com.zc.clickhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhao.cheng
 * @date 2020/9/15 12:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestDataInfo {


    private Long id;


    private String name;


    private Integer sign;


    private Long createTime;


    private String date;
}
