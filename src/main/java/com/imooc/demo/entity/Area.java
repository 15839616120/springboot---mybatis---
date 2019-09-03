package com.imooc.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {
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
