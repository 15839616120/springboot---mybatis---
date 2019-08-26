package com.imooc.demo.controller;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private AreaServiceImpl areaService;

    //innoDB支持行级锁 myslam不支持
    @RequestMapping("hello")
    public String hello(){
        return "hello springboot";
    }

    @RequestMapping("queryAll")
    public List<Area> queryAll(){
        List<Area> areas = areaService.queryArea();
        return areas;
    }

    @RequestMapping("queryAreaById")
    public Area queryAreaById(){
        Area area = areaService.queryAreaById();
        return area;
    }

    @RequestMapping("insertArea")
    public Integer insertArea(){
        int i = areaService.insertArea();
        return i;
    }

    @RequestMapping("updateArea")
    public Integer updateArea(){
        int i = areaService.updateArea();
        return i;
    }

    @RequestMapping("deleteArea")
    public Integer deleteArea(int areaId){
        int i = areaService.deleteArea(areaId);
        return i;
    }
}
