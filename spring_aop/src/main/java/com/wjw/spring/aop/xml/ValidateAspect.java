package com.wjw.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wjwdive
 * @Date 2022/8/8 23:41
 * @Description:
 *
 * 验证 切面的优先级，和LoggerAspect比较看谁先调用. 加入这个是验证有效性的切面
 */

/**
 * 切面类必须是一个组件，然后用切面注解
 */
@Component
//@Aspect
//@Order(1) //数值越小，优先级越高
public class ValidateAspect {

//    @Pointcut("execution(* com.wjw.spring.aop.annotation.*(..))")
//    public void pointCut(){};

//    @Before("execution(* com.wjw.spring.aop.annotation.*(..))")
    public void beforeMethod() {
        System.out.println("ValidateAspect --> 前置通知");
    }



}
