package com.imooc.demo.controller;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private AreaService areaService;

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
}
