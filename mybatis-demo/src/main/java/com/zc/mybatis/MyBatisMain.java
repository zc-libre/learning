package com.zc.mybatis;

import com.zc.mybatis.mapper.UserMapper;
import com.zc.mybatis.pojo.User;
import com.zc.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;


/**
 * @author zhao.cheng
 * @date 2020/10/9 11:29
 */
public class MyBatisMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);

    }
}
