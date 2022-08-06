package com.wjw.mybatis.test;

import com.wjw.mybatis.mapper.CacheMapper;
import com.wjw.mybatis.pojo.Emp;
import com.wjw.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author wjwdive
 * @Date 2022/8/6 16:59
 * @Description:
 */
public class CacheMapperTest {


    /**
     * mybatis 一级缓存：
     * 一级缓存是SqlSession级别的，即通过一个SqlSession查询的数据会被缓存
     * 再次使用同一个sqlSession 查询同一条数据，会从缓存中获取
     *
     * 使用一级缓存时效的情况：
     * 1.不同的SqlSession对应不同的一级缓存
     * 2.同一个SqlSession但是查询条件不同
     * 3.同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4.同一个SqlSession两次查询期间手动清空了缓存
     *
     *
     * mybatis 二级缓存：
     * 二级缓存是SqlSessionFactory级别的，通过一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
     * 二级缓存开启条件：
     * a,在核心配置文件中，设置全局配置属性cacheEnabled = "true", 默认为true,不需要设置
     * b,在映射文件中设置标签<cache/>
     * c,二级缓存必须在SqlSession关闭或提交之后有效
     * d,查询的数据所转换的实体类型必须实现序列化的接口
     *
     * 使二级缓存时效的情况：
     * 两次查询之间执行了任意的增删改，会使得一级和二级缓存同时时效
     */
    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = cacheMapper.getEmpById(3);
        System.out.println("查询结果"+emp);
        //两次查询之间有一次新增操作
        Emp emp11 = new Emp(null, "小明",18,"男");
        cacheMapper.insertEmp(emp11);

        //使用缓存
        Emp emp1 = cacheMapper.getEmpById(3);
        System.out.println("查询结果"+emp1);
        //新的SQLSession 新的一级缓存
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(3);
        System.out.println("查询结果"+emp2);
    }

    @Test
    public void testCached() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper.getEmpById(1);
        System.out.println("查询结果1:"+emp1);
        sqlSession.close();//关闭session1, 验证二级缓存

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println("查询结果2:"+emp2);
    }
}
