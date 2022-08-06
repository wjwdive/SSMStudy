package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wjwdive
 * @Date 2022/8/6 16:54
 * @Description:
 */
public interface CacheMapper {
    /**
     * 根据员工id,查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 插入一个员工信息
     * @param emp
     */
    void insertEmp(Emp emp);
}
