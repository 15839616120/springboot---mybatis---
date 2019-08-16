package com.imooc.springboot_mybatis.entity;

import lombok.Data;

@Data
public class Area {
    //主键id
    private Integer areaId;
    //名称
    private String areaName;
    //权重
    private Integer priority;
    //创建时间
    private String creatTime;
    //更新时间
    private String lastTime;
}
