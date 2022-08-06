package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.DynamicSQLMapper;
import com.wjw.mybatis.pojo.Emp;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/6 11:01
 * @Description:
 */
public class DynamicMapperTest {

    //getEmpByCondition
    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,null,null,"男");
        List<Emp> list = mapper.getEmpByCondition(emp);
        System.out.println("if where条件查询：");
        list.forEach(System.out::println);
    }

    //getEmpByChoose
    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,null,null,null);
        List<Emp> list = mapper.getEmpByChoose(emp);
        System.out.println("where choose 条件查询：");
        list.forEach(System.out::println);
    }

//    insertMoreEmp
    @Test
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"Yarvis",19,"女");
        Emp emp2 = new Emp(null,"Harvis",20,"男");
        Emp emp3 = new Emp(null,"Garvis",21,"男");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(list);
        System.out.println("批量插入的数据：");
        list.forEach(System.out::println);
    }

//    deleteMoreEmp
    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds =  new Integer[]{8,9};
        mapper.deleteMoreEmp(empIds);
        System.out.println("批量删除的员工数据id："+ empIds);
    }
}
