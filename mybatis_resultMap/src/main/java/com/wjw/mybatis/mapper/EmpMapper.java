package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/3 1:27
 * @Description:
 */
public interface EmpMapper {

    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") String empId);

    /**
     * 获取员工及其对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分部查询员工以及所对应的部门信息的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 通过分步查询，查询部门以及员工信息的第二步
     * @return 员工信息集合
     */
    List<Emp> getDeptAndEmpByStemTwo(@Param("deptId") Integer deptId);

}
