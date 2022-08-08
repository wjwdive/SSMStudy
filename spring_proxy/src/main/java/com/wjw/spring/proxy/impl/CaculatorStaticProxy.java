package com.wjw.spring.proxy.impl;

import com.wjw.spring.proxy.Caculator;

/**
 * @Author wjwdive
 * @Date 2022/8/8 21:11
 * @Description:
 */
public class CaculatorStaticProxy implements Caculator {

    //静态代理，一对一
    private CaculatorImpl target;

    public CaculatorStaticProxy(CaculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int x, int y) {
        System.out.println("[日志]，方法：add，参数: "+ x + "," + y);
        int result = target.add(x,y);
        System.out.println("方法内部，result: "+result);
        System.out.println("[日志]，方法：add，结果: "+ result);
        return result;
    }

    @Override
    public int sub(int x, int y) {
        System.out.println("[日志]，方法：sub，参数: "+ x + "," + y);
        int result = target.sub(x, y);
        System.out.println("方法内部，result: "+result);
        System.out.println("[日志]，方法：sub，结果: "+ result);
        return result;
    }

    @Override
    public int mul(int x, int y) {
        System.out.println("[日志]，方法：mul，result: "+ x + "," + y);
        int result = target.mul(x, y);
        System.out.println("方法内部，result: "+result);
        System.out.println("[日志]，方法：mul，结果: "+ result);

        return result;
    }

    @Override
    public int div(int x, int y) {
        System.out.println("日期，方法：div，result: "+ x + "," + y);
        int result = target.div(x, y);
        System.out.println("方法内部，result: "+result);
        System.out.println("[日志]，方法：div，结果: "+ result);

        return result;
    }
}
