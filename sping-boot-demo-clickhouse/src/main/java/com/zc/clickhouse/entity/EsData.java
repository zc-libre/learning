package com.zc.clickhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author zhao.cheng
 * @date 2020/9/25 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "data")
public class EsData {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer sign;

    @Field(type = FieldType.Long)
    private Long createTime;

    @Field(type = FieldType.Date,index = false,format = DateFormat.date)
    private Date date;
}


