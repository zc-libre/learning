package com.zc.pattern.factory.simple.parser;

import com.zc.pattern.factory.simple.RuleConfig;

/**
 * @author zhao.cheng
 * @date 2020/8/31 12:46
 */
public abstract class AbstractRuleConfigParser implements IRuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        RuleConfig ruleConfig = new RuleConfig();
        ruleConfig.setType(configText);
        return ruleConfig;
    }
}
