package com.fh.service.impl;

import com.fh.dao.AreaDao;
import com.fh.model.po.Area;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AreaServiceimpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryAreaList() {
        return areaDao.selectList(null);
    }

    @Override
    public void addArea(Area area) {
        areaDao.insert(area);
    }

    @Override
    public List<Area> queryAreaListByIds(Integer[] ids) {
        //数组转集合
        List<Integer> intIds = Arrays.asList(ids);
        //批量查询
        return  areaDao.selectBatchIds(intIds);
    }
}
