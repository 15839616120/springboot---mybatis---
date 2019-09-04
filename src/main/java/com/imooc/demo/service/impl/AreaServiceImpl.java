package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaMapper;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Area> queryArea(){
        //先看缓存中是否有数据
        List<Area> areas = (List<Area>)redisTemplate.boundValueOps("Areas").get();
        //如果有直接取缓存
        if (null != areas){
            return areas;
        }
        //如果没有查库
        areas = areaDao.queryArea();
        System.out.println(areas);
        //再将数据存入到缓存中去
        redisTemplate.boundValueOps("Areas").set(areas);
        return areas;
    }

    public Area queryAreaById(){
        return areaDao.queryAreaById(1);
    }


    @Transactional
    public int insertArea(){
        Area area = new Area();
        area.setAreaName("南苑1111");
        area.setPriority(4);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        area.setCreatTime(format);
        area.setLastTime(format);
        //返回的依然是影响行数
        int i = areaDao.insertArea(area);
        //int a = 1/0 ;
        area.setAreaName("南苑11111");
        area.setPriority(4);
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        area.setCreatTime(format1);
        area.setLastTime(format1);
        //返回的依然是影响行数
        int ii = areaDao.insertArea(area);
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
    @Override
    public int deleteArea(int areaId){
        int i = areaDao.deleteArea(areaId);
        return i;
    };

    @Override
    public Area queryAreaById(int areaId) {
        return null;
    }

    @Override
    public int insertArea(Area area) {
        return 0;
    }

    @Override
    public int updateArea(Area area) {
        return 0;
    }
}
