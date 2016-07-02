/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.schedule;

import java.util.Date;
import org.quartz.CronExpression;

/**
 * 日程服务
 * @Title: SchedulerService 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:29:22 
 * @version V1.0
 */
public interface SchedulerService {
    /** 
     * 根据 Quartz Cron Expression 调试任务 
     * @param cronExpression  Quartz Cron 表达式，如 "0/10 * * ? * * *"等 
     */  
    void schedule(String cronExpression) throws Exception;  
      
    /** 
     * 根据 Quartz Cron Expression 调试任务 
     * @param name  Quartz CronTrigger名称 
     * @param cronExpression Quartz Cron 表达式，如 "0/10 * * ? * * *"等 
     */  
    void schedule(String name,String cronExpression) throws Exception; 
      
    /** 
     * 根据 Quartz Cron Expression 调试任务 
     * @param name Quartz CronTrigger名称 
     * @param cronExpression Quartz CronExpression 
     */  
    void schedule(String name,CronExpression cronExpression);  
      
    /** 
     * 在startTime时执行调试一次 
     * @param startTime 调度开始时间 
     */  
    void schedule(Date startTime)throws Exception;    
      
    /** 
     * 在startTime时执行调试一次 
     * @param name Quartz SimpleTrigger 名称 
     * @param startTime 调度开始时间 
     */  
    void schedule(String name,Date startTime)throws Exception;  
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     */  
    void schedule(Date startTime,Date endTime)throws Exception;   
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度 
     * @param name Quartz SimpleTrigger 名称 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     */  
    void schedule(String name,Date startTime,Date endTime)throws Exception;  
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     * @param repeatCount 重复执行次数 
     */  
    void schedule(Date startTime,Date endTime,int repeatCount)throws Exception;   
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次 
     * @param name Quartz SimpleTrigger 名称 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     * @param repeatCount 重复执行次数 
     */  
    void schedule(String name,Date startTime,Date endTime,int repeatCount)throws Exception;  
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval秒执行一次 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     * @param repeatCount 重复执行次数 
     * @param repeatInterval 执行时间隔间 
     */  
    void schedule(Date startTime,Date endTime,int repeatCount,long repeatInterval)throws Exception ;  
      
    /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval秒执行一次 
     * @param name Quartz SimpleTrigger 名称 
     * @param startTime 调度开始时间 
     * @param endTime 调度结束时间 
     * @param repeatCount 重复执行次数 
     * @param repeatInterval 执行时间隔间 
     */  
    void schedule(String name,Date startTime,Date endTime,int repeatCount,long repeatInterval)throws Exception;  

}
