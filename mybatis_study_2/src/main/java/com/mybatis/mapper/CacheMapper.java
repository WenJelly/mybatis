package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/*
 *@Time：2023/3/17
 *@Author：Jelly
 */
public interface CacheMapper {

    //缓存只对查询有效
    Emp getEmpByEid(@Param("eid") Integer eid);

}
