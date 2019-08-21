package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {

    /**
     *查询区域列表
     */
    List<Area> queryArea();
    /**
     *根据id查询区域
     */
    Area queryAreaById(int areaId);

    /**
     *插入区域信息
     */
    int insertArea(Area area);

    /**
     *更新区域信息
     */
    int updateArea(Area area);

    /**
     *删除区域信息
     */
    int deleteArea(int areaId);
}
