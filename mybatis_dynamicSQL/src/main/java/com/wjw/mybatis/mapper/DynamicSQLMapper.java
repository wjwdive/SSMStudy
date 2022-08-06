package com.wjw.mybatis.mapper;

import com.wjw.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/6 10:52
 * @Description:
 */
public interface DynamicSQLMapper {
    /**
     * 根据条件来查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 根据choose查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    /**
     * 批量删除员工信息(根据员工id)
     * @param empIds
     */
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);

}
