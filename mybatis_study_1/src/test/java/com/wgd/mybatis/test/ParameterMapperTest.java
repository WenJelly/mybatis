package com.wgd.mybatis.test;

import com.mybatis.mapper.ParameterMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@Time：2023/3/14
 *@Author：Jelly
 */
public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的俩种方式: ${} 和 #{}
     * ${} 本质为字符串拼接 容易造成sql注入
     * #{} 占位符赋值
     * MyBatis获取参数值的各种情况
     * 1.mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值,但是需要主义${}的单引号问题
     * 2.mapper接口方法的参数为多个值
     * 此时MyBatis会将这些参数放在一个map集合中,以俩种方式进行存储
     * 以arg0,arg1.....为键,以参数为值
     * 以param1,param2......为键,以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时,我们可以手动将这些参数放在一个map中
     * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4.mapper接口的参数是一个实体类类型的参数
     * 只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5.使用@Param命名参数
     * 此时MyBatis会将这些参数放在一个map集合中,以俩种方式进行存储
     * 1):以@Param注解的值为键,以参数为值
     * 2):以param1,param2...为键,以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    //全部分为:@Param和实体情况

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User wgd = mapper.getUserByUsername("wgd");
        System.out.println(wgd);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User wgd = mapper.checkLogin("wgd", "6666");
        System.out.println(wgd);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        //键的名称要对应数据库的字段名
        map.put("user_name","wgd");
        map.put("user_pwd","6666");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int wwgd = mapper.insertUser(new User(null, "wwgd", "123"));
        System.out.println(wwgd);
    }

    @Test
    public void testCheckLoginByParma(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User wgd = mapper.checkLoginByParam("wgd", "6666");
        System.out.println(wgd);
    }
}
