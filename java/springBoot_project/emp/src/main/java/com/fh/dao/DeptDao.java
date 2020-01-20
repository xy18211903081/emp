package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Dept;
import com.fh.model.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {
}
