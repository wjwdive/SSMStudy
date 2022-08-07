package com.wjw.spring.service.impl;

import com.wjw.spring.dao.UserDao;
import com.wjw.spring.service.UserService;

/**
 * @Author wjwdive
 * @Date 2022/8/8 1:04
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
