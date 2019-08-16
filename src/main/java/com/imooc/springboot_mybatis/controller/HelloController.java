package com.imooc.springboot_mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //innoDB支持行级锁

    @RequestMapping("hello")
    public String hello(){
        return "hello springboot";
    }
}
