package com.wjw.spring.controller;

import com.wjw.spring.service.UserService;

/**
 * @Author wjwdive
 * @Date 2022/8/8 1:03
 * @Description:
 */
public class UserController {
    //原来写死的方法
//    private UserService userService = new UserService();
    //把实现类交给 IOC 来管理
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }
}
