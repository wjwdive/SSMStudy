package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/2 22:38
 * @Description:
 */
public interface SpecialSqlMapper {

    /**
     * 通过用户名模糊查询用户信息
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUsers(@Param("ids") String ids);

    /**
     * 动态设置表名，查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加一个用户信息，并获取自增的主键。
     * @param user
     */
    void insertUser(User user);

}
