package com.zc.mybatis.mapper;

import com.zc.mybatis.pojo.Role;
import org.apache.ibatis.annotations.Insert;

/**
 * @author zhao.cheng
 * @date 2020/10/9 11:25
 */
public interface RoleMapper {

    Role selectById(Long id);

    @Insert("INSERT INTO role VALUES(#{id}, #{name})")
    void insert(Role role);
}
