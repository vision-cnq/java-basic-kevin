package com.kevin.log;

import org.apache.log4j.Logger;

/**
 * @author kevin
 * @version 1.0
 * @description     将日志的各种级别输出到控制台与文件
 * @createDate 2018/12/29
 */
public class Log4jDemo {

    public static Logger logger = Logger.getLogger(Log4jDemo.class);

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            // 日志的级别从低到高
            // 很低的日志级别一般不会使用
            logger.trace("logger的trace级别");
            // 细粒度信息对调试应用非常有帮助，主要打印一些运行信息
            logger.debug("logger的debug级别");
            // 粗粒度突出强调应用程序的运行过程，打印感兴趣或者重要的信息
            logger.info("logger的info级别");
            // 表明会出现潜在错误的情形，有些信息不是错误信息，但也要给程序员一点提示
            logger.warn("logger的warn级别");
            // 指出虽然发生错误，但不影响运行，打印错误和异常信息，如果不想输出太多日志可以使用该级别
            logger.error("logger的error级别");
            // 每个严重的错误事件将会导致应用程序的退出，出现错误可以停止程序运行进行调试
            logger.fatal("logger的fatal级别");
            try {
                Thread.sleep(1000);
                System.out.println("休眠一分钟");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
            #1.只输出到控制台的日志配置
            #设置级别和目的地（这里可以设置多个目的地）
            log4j.rootLogger = DEBUG,CONSOLE
            #这里的me是包，也就是在这个包记录日志是，是只记录DEBUG及以上级别的日志
            log4j.logger.me = DEBUG
            #输出到控制台
            log4j.appender.CONSOLE = org.apache.log4j.ConsoleAppender
            log4j.appender.CONSOLE.Target = System.out
            log4j.appender.CONSOLE.layout = org.apache.log4j.PatternLayout
            #日志输出的格式
            log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n

         */

        /*
            #2.输出日志到控制台和文件（每天生成一个日志文件）的日志配置
            #设置级别和目的地（这里可以设置多个目的地）
            log4j.rootLogger = DEBUG,CONSOLE,KEVIN
            #这里的me是包，也就是在这个包记录日志是，是只记录DEBUG及以上级别的日志
            log4j.logger.me = DEBUG
            #输出到控制台
            log4j.appender.CONSOLE = org.apache.log4j.ConsoleAppender
            #灵活设置日志格式
            log4j.appender.CONSOLE.layout = org.apache.log4j.PatternLayout
            #日志输出的格式
            log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n
            #输出到日志文件
            log4j.appender.KEVIN = org.apache.log4j.DailyRollingFileAppender
            #选择日志生成的路径
            log4j.appender.KEVIN.File = E:\\log\\JavaBean_log\\debug.log
            log4j.appender.KEVIN.Append = true
            #只输出DEBUG级别以上的日志
            log4j.appender.KEVIN.Threshold = DEBUG
            #'.'yyyy-MM-dd：每天生产一个新的文件
            log4j.appender.KEVIN.DatePattern = '.'yyyy-MM-dd
            log4j.appender.KEVIN.layout = org.apache.log4j.PatternLayout
            log4j.appender.KEVIN.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss} [%t:%r] - [%p] [%c{1}:%L] [%M] %m%n
            log4j.additivity.KEVIN = false
         */

        /*

            #3.输出日志到控制台和文件（根据设置的文件大小限定，达到限定大小则备份，指定备份数量，超出则覆盖）的日志配置
            #设置级别和目的地（这里可以设置多个目的地）
            log4j.rootLogger=DEBUG,Console,KEVIN

            #Console  输出到控制台
            log4j.appender.Console=org.apache.log4j.ConsoleAppender
            #灵活设置日志格式
            log4j.appender.Console.layout=org.apache.log4j.PatternLayout
            #日志输出格式
            log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n

            #输出到文件（根据设置的文件大小限定，达到限定大小则备份，指定备份数量，超出则覆盖）
            log4j.appender.KEVIN = org.apache.log4j.RollingFileAppender
            #输出文件路径
            log4j.appender.KEVIN.File =E:\\log\\JavaBean_log\\RollingFile.log
            #日志文件限定大小
            log4j.appender.KEVIN.MaxFileSize=10MB
            #日志文件备份数量上限
            log4j.appender.KEVIN.MaxBackupIndex=10
            #以HTML表格形式布局
            log4j.appender.KEVIN.layout = org.apache.log4j.PatternLayout
            #日志文件输出格式
            log4j.appender.KEVIN.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n
         */

        /*
            #4.日志输出形式.
            #设置级别和目的地（这里可以设置多个目的地）
            log4j.rootLogger=DEBUG, Console ,File ,DailyRollingFile ,RollingFile

            #Console  输出到控制台
            log4j.appender.Console=org.apache.log4j.ConsoleAppender
            #包含日志信息的级别和信息字符串
            log4j.appender.Console.layout=org.apache.log4j.SimpleLayout
            #日志输出格式
            log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n

            #输出到文件（一直输出到该文件中）
            log4j.appender.File = org.apache.log4j.FileAppender
            #输出日志文件路径
            log4j.appender.File.File = E:\\log\\JavaBean_log\\File.log
            #包含日志产生的时间、线程、类别等等信息
            log4j.appender.File.layout = org.apache.log4j.TTCCLayout
            #日志文件输出格式
            log4j.appender.File.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n

            #输出到文件（根据设置的日期格式，每天生成一个文件）
            log4j.appender.DailyRollingFile = org.apache.log4j.DailyRollingFileAppender
            #输出日志文件路径
            log4j.appender.DailyRollingFile.File = E:\\log\\JavaBean_log\\DailyRollingFile.log
            #日志文件生成周期，当前为每天生成一个文件
            log4j.appender.DailyRollingFile.DatePattern = '.'yyyy-MM-dd-HH-mm
            #灵活指定日志格式
            log4j.appender.DailyRollingFile.layout = org.apache.log4j.PatternLayout
            #日志文件输出格式
            log4j.appender.DailyRollingFile.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n

            #输出到文件（根据设置的文件大小限定，达到限定大小则备份，指定备份数量，超出则覆盖）
            log4j.appender.RollingFile = org.apache.log4j.RollingFileAppender
            #输出文件路径
            log4j.appender.RollingFile.File =E:\\log\\JavaBean_log\\RollingFile.log
            #日志文件限定大小
            log4j.appender.RollingFile.MaxFileSize=10MB
            #日志文件备份数量上限
            log4j.appender.RollingFile.MaxBackupIndex=10
            #以HTML表格形式布局
            log4j.appender.RollingFile.layout = org.apache.log4j.HTMLLayout
            #日志文件输出格式
            log4j.appender.RollingFile.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n
         */
    }
}
