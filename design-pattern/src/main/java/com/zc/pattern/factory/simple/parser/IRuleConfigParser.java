package com.zc.pattern.factory.simple.parser;

import com.zc.pattern.factory.simple.RuleConfig;

/**
 * @author zhao.cheng
 * @date 2020/8/31 12:39
 */
public  interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
