package com.imooc.demo.task;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 集成定时任务需要两步
 * 1)开启定时任务，在springboot启动类上加一个@EnableScheduling
 * 2)在需要定时执行的方法上加上一个注解@Scheduled，这个方法所在的类需要交给springIOC容器管理 ，即加上@Component注解
 */
@Component
public class AreaTask {

    @Autowired
    private AreaServiceImpl areaService;
    /**
     * 定时执行的方法
     * fixedDelay:距离上一次执行完毕之后，隔N毫秒执行。【以结束时间为起点】
     * fixedDelayString：使用配置文件中的占位符作为参数，距离上一次执行完毕之后，隔N毫秒执行。【以结束时间为起点】
     * fixedRate =2000: 距离上次任务开始执行N毫秒之后开始执行，如果上次任务没有按时执行完，且阻塞时间长于N毫秒，则上次任务执行完之后立即执行任务。【以开始时间为起点】
     * fixedRateString:使用配置文件中的占位符作为参数。
     * initialDelay:程序启动后，延迟多少毫秒后开始执行。
     * initialDelayString：使用配置文件中的占位符作为参数。
     * cron:时间表达式
     */

    /*@Scheduled(fixedDelay = 2000)*/
    //@Scheduled(fixedDelayString = "${time.delay}")
    //@Scheduled(fixedRate = 2000)
    //@Scheduled(fixedRateString = "${timeString.delay}")
    //@Scheduled(initialDelay = 10000,fixedDelay = 2000)
    //@Scheduled(cron = "")
    public void task(){
        List<Area> areas = areaService.queryArea();
        System.out.println(LocalDateTime.now());
        System.out.println(areas);
    }
}
