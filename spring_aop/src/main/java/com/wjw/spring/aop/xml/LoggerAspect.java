package com.wjw.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author wjwdive
 * @Date 2022/8/8 22:30
 * @Description:
 *
 * 一、在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before(): 前置方法，在目标对象中方法执行之前标识为切面
 * @After(): 后置方法，在目标对象方法的finally子句里执行
 * @AfterReturning: 后置方法，在目标对象方法的返回值return返回之后执行
 * @AfterThrowing: 后置方法，在目标对象方法的catch子句中执行
 *
 * 二、切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int com.wjw.spring.aop.annotation.Caculator.add(int, int))
 * execution(* com.wjw.spring.aop.annotation.CaculatorImpl.*(..))
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中任意的方法
 * ..表示任意的参数列表
 * 类的地方可以使用*，表示包下所有的类
 *
 * 三、重用切入点表达式
 *     @Pointcut("execution(* com.wjw.spring.aop.annotation.CaculatorImpl.*(..))")
 *     public void pointCut(){}
 *  使用方法：
 * @Before("pointCut()")
 * 四、JoinPoint joinPoint 就是切入点信息对象。
 *  在通知方法的参数位置，设置JoinPoint 类型的参数，就可以获取连接点所对应的方法的信息
 *
 *  //获取连接点所对应方法的签名信息
 *  Signature signature = joinPoint.getSignature();
 *  //获取连接点所对应的对象
 *  Object[] args = joinPoint.getArgs();
 *
 *  各种通知的执行顺序
 *  Spring版本 5.3.x 之前
 *  - 前置通知
 *  - 目标通知
 *  - 后置通知
 *  - 返回通知或异常通知
 *
 *  Spring版本 5.3.x 之后
 *  - 前置通知
 *  - 目标通知
 *  - 返回通知或异常通知
 *  - 后置通知
 *
 * 五、切面的优先级
 * 可以通过@Order注解的value属性，数值优先级，默认值Integer的最大值
 * @Order() 注解的value属性值越小，优先级越高
 */
@Component
//@Aspect //Aspect注解，将类标识为一个切面
public class LoggerAspect {

    //切入点表达式的重用,
    //@Pointcut 用来声明一个公共的切入点表达式
//    @Pointcut("execution(* com.wjw.spring.aop.xml.CaculatorImpl.*(..))")
//    public void pointCut(){}

    /**
     * 这里只切到了 add方法，如何一次性切到多个方法呢
     */
//    @Before("execution(public int com.wjw.spring.aop.annotation.Caculator.add(int, int))")
//    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        System.out.println("LoggerAspect, 前置通知");
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的对象
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 方法： "+ signature.getName() + "; 参数: " + Arrays.toString(args));
    }

    /**
     * *标识类中所有的方法，括号中.. 表示任意的方法中的任意的参数
     */
//    @After("execution(* com.wjw.spring.aop.xml.CaculatorImpl.*(..))")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        System.out.println("LoggerAspect, 后置通知");
    }

    /**
     * 在返回通知中，若要获取目标对象方法的返回值，只需要通过@AfterReturning注解的returning属性。
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     * @param joinPoint
     * @param result
     */
//    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("LoggerAspect 返回通知，结果：" + result);
    }

    /**
     * 在异常通知中若要获取目标对象方法的异常，
     * 只需要通过AfterThrowing 注解的thorwing属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数
     * @param joinPoint
     * @param ex
     */

//    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect 方法： " + signature.getName() + "异常通知: " + ex);
    }


    /**
     * 相当于我们手动写了动态代理
     * 环绕通知的返回值一定要和目标对象方法的返回值一致
     */
//    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        //表示目标对象方法的执行
        Object result = null;
        try {
            //
            System.out.println("环绕通知-->前置通知的位置");
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知的位置");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知的位置");
        } finally {
            System.out.println("环绕通知-->后置通知的位置");
        }
        return result;
    }
}
