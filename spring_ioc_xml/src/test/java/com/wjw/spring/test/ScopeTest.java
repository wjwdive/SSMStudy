package com.wjw.spring.test;

import com.wjw.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/7 22:55
 * @Description:
 */
public class ScopeTest {
    @Test
    public void testSope() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student stu1 = (Student)ioc.getBean("student", Student.class);
        Student stu2 = (Student)ioc.getBean("student", Student.class);
        System.out.println("spring-bean作用域：");
        System.out.println(stu1 == stu2);
    }
}
