package com.zc.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author zhao.cheng
 * @date 2020/12/15 11:53
 */
@MapperScan("com.zc.order.mapper")
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {

}
