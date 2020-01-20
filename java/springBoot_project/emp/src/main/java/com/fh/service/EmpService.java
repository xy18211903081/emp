package com.fh.service;

import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.Job;
import com.fh.model.vo.DeptVo;
import com.fh.model.vo.EmpVo;
import com.fh.util.PageBean;

import java.util.List;

public interface EmpService {
    PageBean<EmpVo> queryEmpList(PageBean<EmpVo> page, EmpVo emp);

    List<Job> queryJobList();

    List<DeptVo> queryDeptList();

    void addEmp(Emp emp);

    Emp queryEmpByName(String empName);
}
