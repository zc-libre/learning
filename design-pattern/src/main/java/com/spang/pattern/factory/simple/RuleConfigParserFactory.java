package com.spang.pattern.factory.simple;

import com.spang.pattern.factory.simple.parser.IRuleConfigParser;
import com.spang.pattern.factory.simple.parser.PropertiesRuleConfigParser;
import com.spang.pattern.factory.simple.parser.XmlRuleConfigParser;
import com.spang.pattern.factory.simple.parser.YmlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao.cheng
 * @date 2020/8/31 12:51
 */
public class RuleConfigParserFactory {

    private static final Map<String,IRuleConfigParser> cacheParsers = new HashMap<>();

    static {
        cacheParsers.put("xml",new XmlRuleConfigParser());
        cacheParsers.put("properties",new PropertiesRuleConfigParser());
        cacheParsers.put("yml",new YmlRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {

        if (configFormat == null || configFormat.isEmpty()) {
            throw new IllegalArgumentException("configFormat is null");
        }

        return cacheParsers.get(configFormat.toLowerCase());
/*        IRuleConfigParser parser = null;

        if ("yml".equals(configFormat)) {
            parser = new YmlRuleConfigParser();
        }else if ("xml".equals(configFormat)) {
            parser = new XmlRuleConfigParser();
        }else if ("properties".equals(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }*/

    }
}
