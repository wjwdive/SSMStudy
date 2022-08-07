package com.wjw.spring.test;

import com.wjw.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/8 1:21
 * @Description:
 * 自动装配： 根据指定的策略，在IOC容器中匹配某个bean,自动为bean中的类类型或接口类型的属性赋值。
 * 自动装配的策略：通过bean的autowire属性设置自动装配
 * 1. no,default: 表示不在装配，即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
 * 2. byType: 根据要赋值的属性的类型，在IOC容器中匹配某个bean,为属性赋值。
 * 注意：
 * 1>若通过类型没有在IOC中找到任何一个类型匹配的bean,此时不匹配， 属性使用默认值
 * 2>若通过类型找到了多个类型匹配的bean，此时会抛出异常：NoUniqueBeanDefinitionException
 * 总结：当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
 * 3. byName:将要赋值的属性的属性名作为bean的id在IOC容器找那个匹配某个bean,为属性赋值
 * 总结：当类型匹配的bean有多个时，此时可以使用byName为属性赋值。
 */
public class AutoWireByXMLTest {
    @Test
    public void testAutoWired() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();//保存成功！
    }

}
