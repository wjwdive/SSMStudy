package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/2 1:19
 * @Description:
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证用户是否登录成功
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录，以map集合作为参数
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 新增一个用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
