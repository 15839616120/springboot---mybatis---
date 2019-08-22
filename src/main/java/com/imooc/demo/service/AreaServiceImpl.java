package com.imooc.demo.service;

import com.imooc.demo.dao.AreaMapper;
import com.imooc.demo.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
