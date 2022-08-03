package com.wjw.mybatis;

import com.wjw.mybatis.mapper.EmpMapper;
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
}
