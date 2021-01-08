package com.zc.pattern.factory.simple;

/**
 * @author zhao.cheng
 * @date 2020/8/31 13:00
 */
public class TestFactory {
    public static void main(String[] args) {
        RuleConfigSource ruleConfigSource = new RuleConfigSource();
        RuleConfig load = ruleConfigSource.load("applcation.properties");
        System.out.println(load);
    }
}
