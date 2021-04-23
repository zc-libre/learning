package com.zc.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao.cheng
 * @date 2021/4/22 15:41
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}
