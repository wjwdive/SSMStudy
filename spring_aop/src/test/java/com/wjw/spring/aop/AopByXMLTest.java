package com.wjw.spring.aop;

import com.wjw.spring.aop.xml.Caculator;
import com.wjw.spring.aop.xml.LoggerAspect;
import com.wjw.spring.aop.xml.ValidateAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/9 0:04
 * @Description:
 */
public class AopByXMLTest {
    @Test
    public void testAop() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Caculator caculator = ioc.getBean(Caculator.class);//无法通过IOC获取目标对象，但是可以获取接口对象
        caculator.add(1,1); //结果ValidateAspect
    }

    @Test
    public void testAopXml() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        ValidateAspect validateAspect = ioc.getBean(ValidateAspect.class);
        validateAspect.beforeMethod();
    }
}
