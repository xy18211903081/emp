package com.fh.service;

import com.fh.model.po.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryAreaList();

    void addArea(Area area);

    List<Area> queryAreaListByIds(Integer[] ids);
}
