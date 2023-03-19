package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@Time：2023/3/15
 *@Author：Jelly
 */
public interface EmpMapper {


    //查询所以的员工信息
    List<Emp> getAllEmp();

    //查询员工以及员工所队医的部门信息
    Emp getEmpAndDept(@Param("eid") Integer eid);

    //通过分步查询来获取员工所对应的部门的信息
    //第一步:查询员工信息
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


    //通过分布查询查询部门以及部门中所以的员工信息
    //第二步,根据did查询员工信息

    List<Emp> getDeptAndEmpByStepTow(@Param("did") Integer did);


}
