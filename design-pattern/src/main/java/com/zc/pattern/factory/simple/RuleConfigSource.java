package com.zc.pattern.factory.simple;

import com.zc.pattern.factory.simple.parser.IRuleConfigParser;

/**
 * @author zhao.cheng
 * @date 2020/8/31 12:33
 */
public class RuleConfigSource {

    public  RuleConfig load(String ruleConfigFilePath) {

        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(fileExtension);

        if (parser == null) {
            throw new RuntimeException("Rule config file format is not supporter: " + ruleConfigFilePath);
        }

        return parser.parse(fileExtension);
    }


    private String getFileExtension(String filePath) {
        int i = filePath.lastIndexOf(".");
        return filePath.substring(i + 1);
    }
}
