package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.EmpMapper;
import com.wjw.mybatis.pojo.Emp;
import com.wjw.mybatis.pojo.EmpExample;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/6 21:14
 * @Description:
 */
public class MybatisMbgTest {
    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println("根据员工id查询数据"+emp);

        List<Emp> list = mapper.selectByExample(null);
        System.out.println("查询全部员工信息:");
        list.forEach(System.out::println);

        //根据条件查询
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameLike("%vis%").andAgeGreaterThan(16);
        List<Emp> list1 = mapper.selectByExample(empExample);
        System.out.println("Example，按姓名模糊查询员工信息:");
        list1.forEach(System.out::println);

        //根据条件查询 加了or()条件
        empExample.or().andAgeGreaterThan(10);
        List<Emp> list2 = mapper.selectByExample(empExample);
        list2.forEach(System.out::println);

        //测试普通修改 Emp对象要加有参构造
        Emp emp2 = new Emp(3, "曹操", null, "男");
//        mapper.updateByPrimaryKey(emp2);//若某个属性为null,那么数据库中这个字段就会被修改为null

        mapper.updateByPrimaryKeySelective(emp2);//若某个属性为null,那么数据库中这个字段的值就不会被修改

    }
}
