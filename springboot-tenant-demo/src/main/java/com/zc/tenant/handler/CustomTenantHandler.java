package com.zc.tenant.handler;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.zc.tenant.prop.TenantProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.schema.Column;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


import static com.zc.tenant.constant.CommonConstant.TENANT_ID;

/**
 * @author zhao.cheng
 * @date 2020/9/27 11:22
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomTenantHandler implements TenantHandler  {

    private final TenantProperties tenantProperties;

    private final List<String> tenantTableList = new ArrayList<>();

    @Override
    public Expression getTenantId(boolean select) {
        log.info(String.valueOf(select));
        // select since: 3.3.2，参数 true 表示为 select 下的 where 条件,false 表示 insert/update/delete 下的条件
        // 只有 select 下才允许多参(ValueListExpression),否则只支持单参

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        Assert.notNull(requestAttributes,"request不能为空！");

        HttpServletRequest request =  ((ServletRequestAttributes) requestAttributes).getRequest();
        String tenantId = request.getParameter(TENANT_ID);
        log.info("当前租户为：{}",tenantId);
        if (!select) {
            // tenant_id = 1
            return new StringValue(StrUtil.nullToDefault(tenantId, "000000"));
        }
        // tenant_id in (1, 2)
        return new StringValue(StrUtil.nullToDefault(tenantId, "000000"));
    }

    @Override
    public String getTenantIdColumn() {
        return tenantProperties.getColumn();
    }

    @Override
    public boolean doTableFilter(String tableName) {
        List<TableInfo> tableInfos = TableInfoHelper.getTableInfos();
         tableInfos.forEach(tableInfo -> {
             boolean exist = tableInfo.getFieldList().stream().anyMatch(tableFieldInfo -> tableFieldInfo.getColumn().equals(tenantProperties.getColumn()));
             if (exist) {
                 tenantTableList.add(tableInfo.getTableName());
             }
         });
        // 这里可以判断是否过滤表
        List<String> excludeTableList = tenantProperties.getExcludeTableList();
        return excludeTableList.stream().anyMatch(excludeTableName -> excludeTableName.equals(tableName))
                && tenantTableList.stream().noneMatch(name -> name.equals(tableName));
    }


}
