package com.zc.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhao.cheng
 * @date 2020/12/15 11:53
 */
@MapperScan("com.zc.account.mapper")
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {


}
