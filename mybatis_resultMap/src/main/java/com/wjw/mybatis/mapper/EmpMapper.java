package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wjwdive
 * @Date 2022/8/3 1:27
 * @Description:
 */
public interface EmpMapper {

    Emp getEmpById(@Param("empId") String empId);
}
