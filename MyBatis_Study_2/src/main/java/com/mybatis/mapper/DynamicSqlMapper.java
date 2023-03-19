package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@Time：2023/3/16
 *@Author：Jelly
 */
public interface DynamicSqlMapper {

    /**
     * 多条件查询(动态SQL)
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试 choose when otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eIds") Integer[] eIds);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
