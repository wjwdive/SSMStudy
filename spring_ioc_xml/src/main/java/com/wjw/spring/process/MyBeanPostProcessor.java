package com.wjw.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author wjwdive
 * @Date 2022/8/7 23:51
 * @Description:
 */

/**
 * 在类的初始化前后 添加一些自定义操作
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器 postProcessBeforeInitialization ");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws  BeansException {
        System.out.println("后置处理器 postProcessAfterInitialization ");
        return bean;
    }
}
