package com.imooc.demo.service;

import com.imooc.demo.dao.AreaMapper;
import com.imooc.demo.entity.Area;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl {

    @Autowired
    private AreaMapper areaDao;

    public List<Area> queryArea(){
        List<Area> areas = areaDao.queryArea();
        System.out.println(areas);
        return areas;
    }

    public Area queryAreaById(){
        return areaDao.queryAreaById(1);
    }


    public int insertArea(){
        Area area = new Area();
        area.setAreaName("南苑111");
        area.setPriority(4);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        area.setCreatTime(format);
        area.setLastTime(format);
        //返回的依然是影响行数
        int i = areaDao.insertArea(area);
        //但是主键已经被赋予实体当中了  useGeneratedKeys="true" keyProperty="areaId"
        System.out.println(area.getAreaId());
        return i;
    };

    /**
     *更新区域信息
     */
    public int updateArea(){
        Area area = areaDao.queryAreaById(1);
        area.setPriority(11);
        int i = areaDao.updateArea(area);
        return i;
    };

    /**
     *删除区域信息
     */
    public int deleteArea(int areaId){
        int i = areaDao.deleteArea(areaId);

        return i;
    };
}
