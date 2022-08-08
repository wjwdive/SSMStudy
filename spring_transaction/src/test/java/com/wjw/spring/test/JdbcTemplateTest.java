package com.wjw.spring.test;

import com.wjw.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/9 0:47
 * @Description:
 */

/**
 * 指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
 * @Execute() Junit 5.x 使用的注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,"Harvis", "0000", 18, "男","123@qq.com");

    }

    @Test
    public void testQueryUserById() {
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),2);
        System.out.println("查询单条数据"+user);
    }

    @Test
    public void testQueryUsers() {
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        System.out.println("查询多条数据"+users);
    }

    @Test
    public void tesGetCount() {
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("单行单列 count: " + count);
    }
}
