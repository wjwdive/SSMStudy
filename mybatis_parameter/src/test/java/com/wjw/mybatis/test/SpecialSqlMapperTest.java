package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.SpecialSqlMapper;
import com.wjw.mybatis.pojo.User;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/2 22:42
 * @Description:
 */
public class SpecialSqlMapperTest {
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List list = mapper.getUserByLike("j");
        System.out.println("查詢結果：");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUsers() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUsers("7,8");
        System.out.println("验证删除...");

    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List list = mapper.getUserList("t_user");
        System.out.println("查詢結果：");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "larvis", "0000", 17, "女", "wjw@163.com");
        mapper.insertUser(user);
        System.out.println("添加結果，去数据库中验证：");
    }

}
