package com.wjw.spring.test;

import com.wjw.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/7 23:24
 * @Description:
 */
public class LifeCycleTest {

    @Test
    public void testLifeCycle() {
        //ConfigurableApplicationContext 是 ApplicationContext 的子接口，其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println("生命周期 User： " + user);
        ioc.close();
        //多例的话，即使关闭ioc容器，也没有执行销毁方法：destroyMethod,生命周期4：销毁

        //单例的话，关闭容器时，会完整打印四个生命周期方法
        /**
         * 生命周期1：实例化
         * 生命周期2：依赖注入
         * 生命周期3：后置处理器 postProcessBeforeInitialization 方法
         * 生命周期4：初始化
         * 生命周期5：后置处理器 postProcessAfterInitialization 方法
         * 生命周期 User： User{id=1001, username='Jarvis', password='0000', age=18}
         * 生命周期6：销毁
         */

        /**
         * BeanFactory 是IOC的一个基本实现
         * FactoryBean 是一个工程bean,需要交给IOC容器来管理，
         */

    }
}
