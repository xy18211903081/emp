package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fh.model.po.Area;
import com.fh.poi.ExcelUtils;
import com.fh.service.AreaService;
import com.fh.util.RedisPools;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("area")
@CrossOrigin
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("queryAreaList")
    @ResponseBody
    public Map queryAreaList(){
        Map map=new HashMap();
        Jedis jedis = RedisPools.getJedis();
        List<Area> areaList =new ArrayList<>();
        try {
            String area = jedis.get("area");
            if(area != null && !area.equals("")){
                areaList = JSON.parseArray(area).toJavaList(Area.class);
                System.out.println("redis-----------------");
            }else {
                areaList= areaService.queryAreaList();
                //把数据放到redis中
                jedis.set("area", JSONArray.toJSONString(areaList));
                System.out.println("mysql-------------");
            }
            map.put("data",areaList);
            RedisPools.returnJedis(jedis);
         }catch (Exception e){
             map.put("message","异常信息为:"+e.getMessage());
         }
        return map;
    }

    @ResponseBody
    @RequestMapping("addArea")
    public Map addArea(Area area){
        Map map=new HashMap();
        areaService.addArea(area);
        map.put("code",200);
        return map;
    }

    @RequestMapping("queryAreaListByIds")
    public void queryAreaListByIds(Integer[] ids, HttpServletResponse response){
      List<Area> list= areaService.queryAreaListByIds(ids);
        ExcelUtils.excel(list, response);
    }
}
