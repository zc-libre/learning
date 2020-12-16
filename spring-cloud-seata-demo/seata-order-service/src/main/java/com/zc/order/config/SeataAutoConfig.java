package com.zc.order.config;

import javax.sql.DataSource;

import com.p6spy.engine.spy.P6DataSource;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.p6spy.engine.spy.P6DataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import javax.sql.DataSource;


import io.seata.rm.datasource.DataSourceProxy;


/**
 * @author zhao.cheng
 * @date 2020/12/15 15:22
 */
@Configuration
@EnableAutoDataSourceProxy
public class SeataAutoConfig {

}

