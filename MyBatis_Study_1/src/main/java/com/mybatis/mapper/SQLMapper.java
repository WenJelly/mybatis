package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@Time：2023/3/15
 *@Author：Jelly
 */
public interface SQLMapper {

    //根据用户名
    List<User> getUserByLike(@Param("user_name") String user_name);

    //批量删除
    int deleteMore(@Param("ids") String ids);

    //查询指定表中的数据
    List<User> getUserByTableName(@Param("tableName") String tableName);

    //添加用户信息
    void insertUser(User user);

}
