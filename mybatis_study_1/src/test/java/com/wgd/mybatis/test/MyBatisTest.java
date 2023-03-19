package com.wgd.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 *@Time：2023/3/13
 *@Author：Jelly
 */
public class MyBatisTest {

    /**
     * SqlSession默认不自动提交事务,若需要自动提交事务
     * 可以使用SqlSessionFactory.openSession(true);
     * @throws IOException
     */

    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //↑代表数据库和Java程序直接的会话
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int rows = mapper.insertUser();
        System.out.println(rows);
        //此时事务还没有提交,所以在数据库中查询不到信息
        //提交事务
        sqlSession.commit();

        //自动提交
//        SqlSession sqlSession = sessionFactory.openSession(true);

    }

    @Test
    public void testCRUD() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //修改
        //int i = mapper.updateUser();
        //删除
        //int i = mapper.deleteUser();
        //查询单个用户信息
        //User userById = mapper.getUserById();
        //查询所有用户信息
        List<User> allUser = mapper.getAllUser();
        
        allUser.forEach(user -> System.out.println(user));
    }
}
