package com.kevin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author kevin
 * @version 1.0
 * @description     测试Quartz定时器
 * @createDate 2019/3/20
 */
public class QuartzTest {

    public static void main(String[] args) throws SchedulerException {

        //1.创建Job对象，你要做什么事？
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 简单的trigger触发时间
         * cron Trigger：按照Cron的表达式来给定触发的时间
         * repeatSecondlyForever()：表示每秒执行一次
         */
        //2.创建Trigger对象，在什么时间做？
        //Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();        // 使用trigger内置的
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();      // 使用cron表达式
        //3.创建Scheduler对象，在什么时间做什么事？
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);

        //4.启动
        scheduler.start();

    }

}
