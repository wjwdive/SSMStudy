package com.wjw.spring.proxy.text;


import com.wjw.spring.proxy.Caculator;
import com.wjw.spring.proxy.ProxyFactory;
import com.wjw.spring.proxy.impl.CaculatorImpl;
import com.wjw.spring.proxy.impl.CaculatorStaticProxy;
import org.junit.Test;

/**
 * @Author wjwdive
 * @Date 2022/8/8 21:19
 * @Description:
 */
public class CaculatorTest {
    @Test
    public void testCaculator() {
        CaculatorImpl caculatorImpl = new CaculatorImpl();
        CaculatorStaticProxy cp = new CaculatorStaticProxy(caculatorImpl);
        int re = cp.add(1,2);
        System.out.println("proxy 结果：" + re);
    }

    @Test
    public void testProxy() {
        ProxyFactory proxyFactory = new ProxyFactory(new CaculatorImpl());
        Caculator proxy = (Caculator) proxyFactory.getProxy();

        proxy.add(1,1);

    }

}
