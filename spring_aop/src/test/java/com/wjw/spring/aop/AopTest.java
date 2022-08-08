package com.wjw.spring.aop;

import com.wjw.spring.aop.annotation.Caculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/8 22:43
 * @Description:
 */
public class AopTest {
    @Test
    public void testAop() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Caculator caculator = ioc.getBean(Caculator.class);//无法通过IOC获取目标对象，但是可以获取接口对象
        caculator.add(1, 1);
    }


    @Test
    public void testAop1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Caculator caculator = ioc.getBean(Caculator.class);//无法通过IOC获取目标对象，但是可以获取接口对象
        caculator.div(1, 1);
    }
}
