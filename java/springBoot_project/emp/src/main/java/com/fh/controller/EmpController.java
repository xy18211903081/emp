package com.fh.controller;

import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.Job;
import com.fh.model.vo.DeptVo;
import com.fh.model.vo.EmpVo;
import com.fh.service.EmpService;
import com.fh.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("emp")
@CrossOrigin
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("queryEmpList")
    public PageBean<EmpVo> queryEmpList(PageBean<EmpVo> page ,EmpVo emp){
        return empService.queryEmpList(page,emp);
    }


    @RequestMapping("queryJobList")
    public Map queryJobList(){
        Map map=new HashMap();
        List<Job> list = empService.queryJobList();
        map.put("data",list);
        return map;
    }

    @RequestMapping("queryDeptList")
    public Map queryDeptList(){
        Map map=new HashMap();
        List<DeptVo> list = empService.queryDeptList();
        map.put("data",list);
        return map;
    }

    @RequestMapping("addEmp")
    public Map addEmp(Emp emp){
        Map map=new HashMap();
        Emp emps =empService.queryEmpByName(emp.getEmpName());
        if(emps.getEmpName() ==null){
            empService.addEmp(emp);
            map.put("code",200);
        }else {
            map.put("message","用户已存在");
        }
        return map;
    }
}
