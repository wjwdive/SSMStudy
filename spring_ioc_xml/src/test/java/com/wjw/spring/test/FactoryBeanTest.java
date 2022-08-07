package com.wjw.spring.test;

import com.wjw.spring.factory.UserFactoryBean;
import com.wjw.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/8 0:56
 * @Description:
 */
public class FactoryBeanTest {
    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);//这里不是UserFactoryBean,
        System.out.println("FactoryBean 创建 对象： " + user);
    }
}
