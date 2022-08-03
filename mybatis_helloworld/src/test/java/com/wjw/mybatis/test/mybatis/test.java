package com.wjw.mybatis.test.mybatis;

import com.wjw.mybatis.mapper.UserMapper;
import com.wjw.mybatis.pojo.User;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/1 22:31
 * @Description:
 */
public class test {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession(不会自动提交事务), 是MyBatis 提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置自动提交事务的sqlSession
        //获取UserMapper的代理实例对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //通过代理对象，创建接口对象的实现类对象
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = userMapper.insertUser(); //mybatis 默认是回滚的，需要手动提交，只执行sql语句，不执行commit，sql会自动回滚
        //通过mapper接口的全类名来找到映射文件，通过mapper接口中的方法来找到sql语句, 上一条语句等价于
        //int result1 = sqlSession.insert("com.wjw.mybatis.mapper.insertUser");
        System.out.println("结果:" + result);
        //手动提交事务，,sqlSessionFactory配置了自动提交的时候，这里不在手动提交
        //sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testQuery() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById();
        System.out.println("查询结果：" + user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getAllUser();
        list.forEach(System.out::println);//打印输出 list
        sqlSession.close();
    }
}
