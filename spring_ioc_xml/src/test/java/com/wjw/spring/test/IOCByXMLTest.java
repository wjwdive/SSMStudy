package com.wjw.spring.test;


import com.wjw.spring.pojo.Clazz;
import com.wjw.spring.pojo.Person;
import com.wjw.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wjwdive
 * @Date 2022/8/7 9:56
 * @Description:
 */
public class IOCByXMLTest {

    /**
     * 获取bean的三种方式：
     * 1.根据bean的id获取
     * 2.根据bean的类型获取
     * 3.根据bean的id和类型获取
     * 0
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 若没有任何一个类型匹配的bean,此时抛出异常：NoSuchBeanDefinitionException
     * 若有多个类型匹配的bean,此时抛出异常：NoUniqueBeanDefinitionException
     *
     * 结论：
     * 根据类型来获取bean时，在满足bean唯一性的前提下，
     * 其实只看：【对象 **instance of** 指定的类型】的返回结果
     * 只要返回的是true就可以认定为和类型匹配，能够获取到
     * 即通过bean的类型，bean所继承的类型，bean所实现的接口的类型都可以获取bean
     *
     * spring-ioc.xml
     * xml文件中特殊属性的配置：
     * null     <null/>
     * <    &lt;
     * >    &gt;
     * <![CDATA[<王五>]]  CDATA 节中的内容会原样解析
     * CDATA节是xml中写什么符号都随意。
     * 类类型
     *
     */

    @Test
    public void testIOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean的三种方式
        Student student = ioc.getBean(Student.class);
        Student student1 = (Student)ioc.getBean("Student");
        Student student2 = (Student)ioc.getBean("Student",Student.class);
        System.out.println("student: "+ student);//Student{sid=null, sname='null', age=null, gender='null'}
        //若没有初始值，每一个引用类型都是'null'
        //Person是Student的接口对象，Student实现了Person的接口
        //这样写没有错，ioc通过一个接口对象，来匹配一个Bean
        Person student3 = ioc.getBean(Person.class);
        System.out.println("ioc通过一个接口对象，来匹配一个Bean"+student3);
    }

    @Test
    public void testDI() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student stu = ioc.getBean("StudentSix", Student.class);
        System.out.println("setter 注入： "+ stu);
    }

    @Test
    public void testDISeven() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student stu = ioc.getBean("StudentEight", Student.class);
        System.out.println(" 注入bean： "+ stu);
    }

    @Test
    public void testDIEight() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Clazz clazz = ioc.getBean("ClazzTwo", Clazz.class);
        System.out.println(" calzz注入包含引用，数组，list<bean>： "+ clazz);
    }


    @Test
    public void testDITen() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student st = ioc.getBean("StudentEleven", Student.class);
        System.out.println(" st，数组，： "+ st);
    }




}
