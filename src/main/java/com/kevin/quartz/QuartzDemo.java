package com.kevin.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description     Quartz定时器
 * @createDate 2019/3/20
 */
public class QuartzDemo implements Job {

    // 任务被触发时所执行的方法
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..."+new Date());
    }
}
