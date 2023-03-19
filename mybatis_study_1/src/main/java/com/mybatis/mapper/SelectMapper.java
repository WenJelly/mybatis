package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 *@Time：2023/3/15
 *@Author：Jelly
 */
public interface SelectMapper {

    //根据id查询用户信息
    User getUserById(@Param("user_id") Integer id);

    //查询所有的用户信息
    List<User> getAllUser();

    //查询用户信息的总记录数
    Integer getCount();

    //根据id查询用户信息为一个map集合
    Map<String,Object> getUserByIdToMap(@Param("user_id") Integer user_id);

    //查询所有用户信息为map集合
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("user_id")//找一个唯一的字段来当键,然后将另一个包含全部信息的Map集合当成这个键的值
    Map<String,Object> getAllUserToMap();
}

