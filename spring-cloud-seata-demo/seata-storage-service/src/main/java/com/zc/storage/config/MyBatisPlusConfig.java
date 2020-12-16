package com.zc.storage.config;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhao.cheng
 * @date 2020/12/15 11:53
 */
@MapperScan("com.zc.storage.mapper")
@Configuration
@EnableAutoDataSourceProxy
public class MyBatisPlusConfig {


}
