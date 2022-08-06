package com.wjw.mybatis;

import com.wjw.mybatis.mapper.DeptMapper;
import com.wjw.mybatis.mapper.EmpMapper;
import com.wjw.mybatis.pojo.Dept;
import com.wjw.mybatis.pojo.Emp;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * @Author wjwdive
 * @Date 2022/8/3 1:32
 * @Description:
 */
public class ResultTest {
    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpById("4");
        System.out.println("查询结果"+emp);
    }

    @Test
    public void testGetEmpAndDeptByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByEmpId(1);
        System.out.println("查询结果"+emp);
    }

    @Test
    public void testGetEmpAndDeptByStepOne() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(1);
        System.out.println("多对一，分步查询结果"+emp);
    }

    @Test
    public void testGetDeptAndEmpByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByDeptId(1);
        System.out.println("查询部门以及部门的员工信息,查询结果"+dept);
    }

    @Test
    public void testGetDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByStepOne(1);
        System.out.println("查询部门以及部门的员工信息,分步查询结果"+dept);
    }
}
