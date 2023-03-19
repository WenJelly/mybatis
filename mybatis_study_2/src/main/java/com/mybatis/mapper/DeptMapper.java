package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@Time：2023/3/15
 *@Author：Jelly
 */
public interface DeptMapper {

    //通过分步查询来获取员工所对应的部门的信息
    //第二步:通过did查询员工所对应的部门
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    //获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);

    //通过分布查询查询部门以及部门中所以的员工信息
    //第一步,查询部门信息
    Dept getDeptAndEmpByShepOne(@Param("did") Integer did);

}
