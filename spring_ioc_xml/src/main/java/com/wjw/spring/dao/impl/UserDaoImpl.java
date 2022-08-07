package com.wjw.spring.dao.impl;

import com.wjw.spring.dao.UserDao;

/**
 * @Author wjwdive
 * @Date 2022/8/8 1:07
 * @Description:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功！");
    }
}
