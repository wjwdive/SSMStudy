package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.SelectMapper;
import com.wjw.mybatis.pojo.User;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/2 21:33
 * @Description:
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
//        SelectMapperTest selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(2);
        System.out.println("按id查询用户信息" + user);
    }

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List list = selectMapper.getAllUsers();
        System.out.println("查詢結果：");
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = selectMapper.getUserCount();
        System.out.println("查詢結果個數："+count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = selectMapper.getUserByIdToMap(2);
//        返回值为null的结果不会放在map里
        System.out.println("查詢一条数据map結果："+map);
    }

    @Test
    public void testGetUsersToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        //还是以List返回
//        List<Map<String, Object>>  list = (List<Map<String, Object>>) selectMapper.getAllUsersToMap();
////        返回值为null的结果不会放在map里
//        System.out.println("查詢結果：");
//        list.forEach(System.out::println);
        //以id为键，以每条数据对象为value
        Map<String, Object> map = (Map<String, Object>) selectMapper.getAllUsersToMap();
        System.out.println(map);
        /*
        * {
        * 2={password=0000, gender=男, id=2, age=18, email=123456@qq.com, username=admin},
        * 3={password=123, gender=男, id=3, age=18, email=123456@qq.com, username=jarvis},
        * 4={password=0000, gender=男, id=4, age=18, email=123456@qq.com, username=admin},
        * 5={password=0000, gender=男, id=5, age=18, email=123@qq.com, username=Marvis}
        * }
        * */
    }
}
