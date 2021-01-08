package com.zc.account.config;

import javax.sql.DataSource;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

import io.seata.rm.datasource.DataSourceProxy;

/**
 * @author zhao.cheng
 */
@Configuration
public class SeataAutoConfig {
}

