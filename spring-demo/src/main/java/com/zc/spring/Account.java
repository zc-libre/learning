package com.zc.spring;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author zhao.cheng
 * @date 2020/9/4 10:42
 */
@ToString
@Slf4j
@Configurable(autowire= Autowire.BY_NAME, preConstruction = true)
public class Account {


    private String name;

    @Autowired
    private BeanA beanA;

    public Account() {
        log.info("init!");
    }

    public Object getBeanA() {
        return beanA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}