package com.wjw.spring.aop;

import com.wjw.spring.aop.annotation.Caculator;
import com.wjw.spring.aop.annotation.CaculatorImpl;
import com.wjw.spring.aop.annotation.LoggerAspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/8 22:43
 * @Description:
 */
public class test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
    Caculator caculator = ioc.getBean(Caculator.class);
    caculator.add(1, 1);
    LoggerAspect log = ioc.getBean(LoggerAspect.class);
}
