package com.zc.mybatis.mapper;

import com.zc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhao.cheng
 * @date 2021/4/23 14:08
 */
@Mapper
public interface UserMapper {

    @Select("select * from `user` where id = #{id}")
    User selectOne(Integer id);
}
