package com.wjw.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjw.mybatis.mapper.EmpMapper;
import com.wjw.mybatis.pojo.Emp;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;

/**
 * @Author wjwdive
 * @Date 2022/8/6 22:11
 * @Description:
 */
public class PageTest {
    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //查询开始之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        //查询所有员工信息
        List<Emp> list = mapper.selectByExample(null);
        System.out.println("分页查询："+ page);

        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);//导航分页的页码数
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}

/**
 * PageInfo{pageNum=1, pageSize=4, size=4, startRow=1, endRow=4, total=5, pages=2,
 * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=5, pages=2, reasonable=false, pageSizeZero=false}
 * [Emp{empId=1, empName='张三', age=18, gender='男', deptId=1},
 * Emp{empId=2, empName='李四', age=19, gender='女', deptId=1},
 * Emp{empId=3, empName='曹操', age=33, gender='男', deptId=null},
 * Emp{empId=7, empName='Yarvis', age=19, gender='女', deptId=null}],
 * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=5, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
 */
