package com.wjw.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @Author wjwdive
 * @Date 2022/8/8 20:47
 * @Description:
 *
 * 实现一个日志功能
 * 代码缺陷：
 * 1.核心业务代码和非核心代码混合在了一起
 * 2.
 *
 * 解决：要抽取的代码在方法的内部，靠以前把子类中重复代码抽取到父类的方法没法解决
 *
 * 代理模式：
 * 属于结构模式，它的作用是通过代理对象，访问目标对象。代理对象里执行一些非核心代码，而不影响目标对象中的核心代码。
 */
@Component
public class CaculatorImpl implements Caculator {

    @Override
    public int add(int x, int y) {
//        System.out.println("[日志]，方法：add，参数: "+ x + "," + y);
        int result = x + y;
        System.out.println("方法内部，result: "+result);
//        System.out.println("[日志]，方法：add，结果: "+ result);

        return result;
    }

    @Override
    public int sub(int x, int y) {
//        System.out.println("[日志]，方法：sub，参数: "+ x + "," + y);
        int result = x - y;
        System.out.println("方法内部，result: "+result);
//        System.out.println("[日志]，方法：sub，结果: "+ result);

        return result;
    }

    @Override
    public int mul(int x, int y) {
//        System.out.println("[日志]，方法：mul，result: "+ x + "," + y);
        int result = x * y;
        System.out.println("方法内部，result: "+result);
//        System.out.println("[日志]，方法：mul，结果: "+ result);

        return result;
    }

    @Override
    public int div(int x, int y) {
//        System.out.println("日期，方法：div，result: "+ x + "," + y);
        int result = x / y;
        System.out.println("方法内部，result: "+result);
//        System.out.println("[日志]，方法：div，结果: "+ result);

        return result;
    }
}
