package com.fh.service.impl;

import com.fh.dao.DeptDao;
import com.fh.dao.EmpDao;
import com.fh.dao.JobDao;
import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.Job;
import com.fh.model.vo.DeptVo;
import com.fh.model.vo.EmpVo;
import com.fh.service.EmpService;
import com.fh.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmpServiceimpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private DeptDao deptDao;

    @Override
    public PageBean<EmpVo> queryEmpList(PageBean<EmpVo> page, EmpVo emp) {
        long count =empDao.queryCount(emp);
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);
        List<EmpVo> list =empDao.queryEmpList(page,emp);
        page.setData(list);
        return page;
    }

    @Override
    public List<Job> queryJobList() {
        return jobDao.selectList(null);
    }

    @Override
    public List<DeptVo> queryDeptList() {
        return empDao.queryDeptList();
    }

    @Override
    public void addEmp(Emp emp) {

        empDao.insert(emp);
    }

    @Override
    public Emp queryEmpByName(String empName) {
        return empDao.queryEmpByName(empName);
    }
}
