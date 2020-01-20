package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Emp;
import com.fh.model.vo.DeptVo;
import com.fh.model.vo.EmpVo;
import com.fh.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpDao extends BaseMapper<Emp> {
    long queryCount(@Param("emp") EmpVo emp);

    List<EmpVo> queryEmpList(@Param("page") PageBean<EmpVo> page, @Param("emp") EmpVo emp);

    Emp queryEmpByName(String empName);

    List<DeptVo> queryDeptList();
}
