package com.zc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhao.cheng
 * @date 2020/9/4 10:50
 */
public class Test {

        public static void main(String[] args) {
            ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.zc.spring");
            Account accountA=new Account();
            System.out.println(accountA);
        }
    }

