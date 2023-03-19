package com.wgd.mybatis.test;

import com.mybatis.mapper.SelectMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/*
 *@Time：2023/3/15
 *@Author：Jelly
 */
public class SelectMapperTest {

    /**
     *MyBatis的各种查询功能:
     *
     * 1.若查询出的数据只有一条.
     * a>可以通过实体类对象接收r
     * b>可以通过List集台接收
     * c>可以通过map集合接收
     *
     * 2.若查询出的数据有多条
     * a>可以通过List集合接收甲
     * b>可以通过map类型的List集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解,此时就可以将每条数据转换的map集合作为值,以某个的值作为键,放在同一个Map集合中
     * 注意:一定不能通过实体类对象接收,此时会抛异常TooManyResultsException
     *
     * MyBatis 中设置了默认的类型别名
     * java.Lang.Integer-->int,integer
     * int-->_int,_integer
     * Map --->map
     * String-->string
     *
     */

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(10000);
        System.out.println(userById);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(10000);
        System.out.println(userByIdToMap);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
}
