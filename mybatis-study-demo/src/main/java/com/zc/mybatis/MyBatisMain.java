package com.zc.mybatis;

import com.zc.mybatis.mapper.RoleMapper;
import com.zc.mybatis.pojo.Role;
import com.zc.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author zhao.cheng
 * @date 2020/10/9 11:29
 */
public class MyBatisMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
     //   Role role = mapper.selectById(1L);
     //   System.out.println(role);
        mapper.insert(new Role(2L, "CD"));
    }
}
