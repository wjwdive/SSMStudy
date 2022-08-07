package com.wjw.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @Author wjwdive
 * @Date 2022/8/7 21:22
 * @Description:
 */
public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {//不抛出错误回报：java: 未报告的异常错误java.sql.SQLException; 必须对其进行捕获或声明以便抛出
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        //输出连接的 内存地址
        System.out.println(dataSource.getConnection());//连接错误：严重: {dataSource-1} init error,原因driver拼写错误：
        //driver = "com.mysql.cj.jdbc.Java"

    }
}
