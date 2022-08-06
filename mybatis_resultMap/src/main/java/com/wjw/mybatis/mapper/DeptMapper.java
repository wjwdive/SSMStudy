package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wjwdive
 * @Date 2022/8/3 1:28
 * @Description:
 */
public interface DeptMapper {
    /**
     * 通过分步查询，查询员工以及所对应的部门信息的第二步
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门的员工信息 一对多查询
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询，查询部门以及员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
