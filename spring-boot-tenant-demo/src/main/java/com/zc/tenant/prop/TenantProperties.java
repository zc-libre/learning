package com.zc.tenant.prop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2020/9/27 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("zc.tenant")
public class TenantProperties {

    /**
     * 排除的表
     */
    private List<String>  excludeTableList = new ArrayList<>(Collections.singletonList("user"));

    /**
     * 多租戶字段
     */
    private String column = "tenant_id";


}
