package com.zc.tenant.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.zc.tenant.prop.TenantProperties;
import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.stereotype.Component;

/**
 * @author zhao.cheng
 * @date 2020/9/28 10:47
 */
@Component
@RequiredArgsConstructor
public class InnerLineTenantHandler implements TenantLineHandler {

    private final TenantProperties tenantProperties;

    @Override
    public Expression getTenantId() {
        return new StringValue("000000");
    }

    @Override
    public String getTenantIdColumn() {
        return tenantProperties.getColumn();
    }

    /**
     * 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
     */
    @Override
    public boolean ignoreTable(String tableName) {
       // return !"user".equalsIgnoreCase(tableName);
        return false;
    }
}
