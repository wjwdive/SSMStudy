package com.wjw.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author wjwdive
 * @Date 2022/8/8 21:26
 * @Description:
 */
//工厂，专门用来生成任何目标类的代理类。代理类是运行时生成的。

/**
 * 动态代理有两种： AOP 的底层就是动态代理
 * 1.jdk动态代理： 要求必须有接口，最终生成的代理类和目标类实现相同的接口。在com.sun.proxy包下，类名为$proxy2
 * 2.cglib动态代理：最终生成的代理类会继承目标类，并且和目标类在相同的包下。Dobble
 */

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    /**
     * 类加载器:
     * 1.根类加载器，C语言实现，用来加载核心类库
     * 2.扩展类加载器，加载扩展类库
     * 3.应用类加载器，加载自定义的类和第三方架包里的类，
     * 4.
     * @return
     */
    public Object getProxy() {
        /**
         * ClassLoader loader， 类加载器. 指定加载动态生成的代理类的类加载器
         * Class[] interfaces:  获取目标对象实现的所有接口的class对象数组
         * InvocationHandler h: 设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * proxy:表示代理对象，
                 * method：表示要执行的方法
                 * args: 表示要执行的方法的参数列表
                 */
                Object result = null;
                try {
                    System.out.println("[日志] 方法：" + method.getName() + ",参数： " + Arrays.toString(args));
                    result = method.invoke(classLoader, args);
                    System.out.println("[[日志] 方法：" + method.getName() + ",结果：" + result);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    //错误日志
                    System.out.println("[[日志] 方法：" + method.getName() + ",异常：" + e);
                } finally {
                    //关闭资源等操作
                    System.out.println("[[日志] 方法：" + method.getName() + "方法执行完毕~");
                }

                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}

/**
 * oop,纵向继承
 * AOP,横向代理： 通过编译方式和运行期动态代理方式 最终实现在不修改源代码的情况下给程序添加一些额外的功能
 *
 *
 * 术语：
 * 1。横切关注点： 每个方法中抽取出来的同一类非核心业务。在同一项目中可以使用多个横切关注点，对相关方法进行多个 不同方面的增强。
 *  不是语法层面的概念，而是功能层面的概念
 * 2. 通知： 把横切关注点封装到一个切面类中。每个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。
 *  a. 前置通知，被代理的目标对象方法前执行
 *  b. 返回通知。。。。方法成功结束后
 *  c. 异常结束后 catch
 *  d. 最终结束 finally
 *  e. 环绕通知： try...catch...finally
 * 3. 切面： 封装通知方法的类
 * 4. 目标： 当前的目标对象，要进行功能增强的对象
 * 5. 代理： 向目标对象应用通知之后创建的代理对象
 * 6. 连接点： 这也是一个纯逻辑概念。不是语法定义。从哪抽出来，还要把它套到哪里。
 * 7. 切入点： 定位连接点的方式。就是一个表达式。从代码的方式表示连接点
 *
 *
 * AOP 作用：
 * 1.简化代码
 * 2.代码增强
 *
 * AOP是一种思想，AspectJ 是这种思想的实现。
 * 1.动态代理： invocationHandler, JDK原生实现方式，需要被代理的目标必须实现接口。因为这种技术要求代理对象和目标对象实现同样的接口（两兄弟拜把子模式）
 * 2.cglib: 通过继承被代理的目标类（认干爹模式）实现代理，所以不需要目标类实现接口。
 * 3.AspectJ: 本质是静态代理，将代理逻辑“织入”被代理的目标类编译得到的字节码文件，所以最终效果是动态的。weaver是织入器，Spring只是借用了Aspect中的注解。
 *
 */