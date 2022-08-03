package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.User;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/1 22:22
 * @Description:
 */
public interface UserMapper {
    /**
     * 插入一条数据
     * @return
     */
    int insertUser();

    /**
     * 更新数据
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     * @return
     */
    User queryUserById();

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();


}
