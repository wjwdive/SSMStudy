package com.wjw.spring.test;

import com.wjw.spring.controller.UserController;
import com.wjw.spring.dao.UserDao;
import com.wjw.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/8 1:58
 * @Description:
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);

        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }


}
