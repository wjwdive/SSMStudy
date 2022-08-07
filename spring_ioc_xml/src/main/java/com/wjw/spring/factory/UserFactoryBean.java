package com.wjw.spring.factory;

import com.wjw.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author wjwdive
 * @Date 2022/8/8 0:41
 * @Description:
 */

/**
 * FactoryBean是一个接口，需要创建一个类实现接口
 * 三个方法：
 * getObject(): 通过一个对象交给IOC容器管理
 * getObjectType(): 设置所提供对象的类型
 * isSingleton(): 所提供对象是否单例
 * 当把FactoryBean 的实现类配置为bean时，会将当前类中getObject()所返回的对象交给IOC容器
 */
public class UserFactoryBean extends User implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
