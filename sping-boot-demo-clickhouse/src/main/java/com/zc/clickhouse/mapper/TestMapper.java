package com.zc.clickhouse.mapper;

import com.zc.clickhouse.entity.TestDataInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhao.cheng
 * @date 2020/9/15 10:48
 */
@Mapper
@Repository
public interface TestMapper {

    @Insert("insert into test (id, `name`,sign, `date`, createTime) values (#{id}, #{name},#{sign},#{date},#{createTime})")
    void insert(TestDataInfo testData);
}
