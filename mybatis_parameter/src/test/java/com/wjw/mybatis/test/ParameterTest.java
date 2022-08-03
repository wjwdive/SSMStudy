package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.UserMapper;
import com.wjw.mybatis.pojo.User;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/2 1:35
 * @Description:
 */
public class ParameterTest {
    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername("jarvis");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("jarvis", "123");
        System.out.println("登录信息："+user);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "jarvis");
        map.put("password", "123");
        User user = userMapper.checkLoginByMap(map);
        System.out.println("登录信息："+user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "Marvis", "0000", 18, "男", "123@qq.com");
        userMapper.insertUser(user);
        System.out.println("新增成功！"+ user.getUsername());
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "Sarvis", "0000", 17, "男", "123@qq.com");
        userMapper.insertUser(user);
        System.out.println("新增成功！"+ user);
    }

}
