package com.zc.tenant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author zhao.cheng
 * @date 2020/9/27 15:14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tenant")
public class TenantInfo extends TenantEntity{

    @TableId
    private Long id;

    private String name;

}
