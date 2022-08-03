package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/2 21:28
 * @Description:
 */
public interface SelectMapper {

    /**
     * 若sql语句查询的结果为多条时，一定不能以实体类型作为方法的返回值
     * 否则会抛出一场 TooManyResultsException
     * 若sql语句查询的结果为1条时，此时可以使用实体类型或list集合类型作为方法的返回值
     */


    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();

//    查询列表中数据条数
    Integer getUserCount();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户为map集合
     * 1.若查询的数据有多条时，并且要将每条数据转换为map的list集合
     * List<Map<String, Object>>
     * 2.可以将每条数据转换为map集合，放在一个大的map中。但是必须要通过MapKey注解
     * @return
     */
    @MapKey("id")
    Map<String, Object> getAllUsersToMap();

}
