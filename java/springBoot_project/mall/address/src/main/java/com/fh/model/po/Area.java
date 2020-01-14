package com.fh.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fh.poi.ExcelFild;
import com.fh.poi.ExcleHeard;

import javax.persistence.Table;
import java.io.File;

@TableName("t_area")
@ExcleHeard(title = "地区表")
public class Area {
    @TableId(value = "id",type = IdType.AUTO)
   @ExcelFild(Field = "主键")
    private Integer id;
   @ExcelFild(Field = "父ID")
    private Integer pid;
  @ExcelFild(Field = "地区名")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
