package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 *@Time：2023/3/14
 *@Author：Jelly
 */
public interface ParameterMapper {

    //查询所有员工信息
    List<User> getAllUser();

    //根据用户名查询用户信息
    User getUserByUsername(String user_name);

    //通过用户名和密码来验证
    User checkLogin(String user_name,String user_password);

    //验证登录(参数为Map集合)
    User checkLoginByMap(Map<String,Object> map);

    //添加用户信息
    int insertUser(User user);

    //登录功能5
    User checkLoginByParam(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);


}
