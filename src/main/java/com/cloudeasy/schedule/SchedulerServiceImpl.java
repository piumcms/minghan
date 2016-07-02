/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.schedule;


import java.util.Date;
import java.util.UUID;

import org.quartz.CronExpression;
import org.springframework.stereotype.Service;


/**
 * 日程服务实现类
 * @Title: SchedulerServiceImpl 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:29:53 
 * @version V1.0
 */
@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {
    
    
    //@Autowired
    //private Scheduler scheduler;
    
   // @Autowired
    //private JobDetail jobDetail;  
  
    public void schedule(String cronExpression) throws Exception {  
        schedule(null, cronExpression);  
    }  

    public void schedule(Date startTime) throws Exception{  
        schedule(startTime, null);  
    }  
  
    public void schedule(String name, Date startTime) throws Exception{  
        schedule(name, startTime, null);  
    }  
  
    public void schedule(Date startTime, Date endTime) throws Exception{  
        schedule(startTime, endTime, 0);  
    }  
  
    public void schedule(String name, Date startTime, Date endTime) throws Exception{  
        schedule(name, startTime, endTime, 0);  
    }  
  
    public void schedule(Date startTime, Date endTime, int repeatCount) throws Exception{  
        schedule(null, startTime, endTime, 0);  
    }  
  
    public void schedule(String name, Date startTime, Date endTime, int repeatCount) throws Exception{  
        schedule(name, startTime, endTime, 0, 0L);  
    }  
  
    public void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval) throws Exception {  
        schedule(null, startTime, endTime, repeatCount, repeatInterval);  
    }  
    
    public void schedule(String name, String cronExpression) throws Exception {
        
        if (name == null || name.trim().equals("")) {  
            name = UUID.randomUUID().toString();  
        }
        /*
        try {
           scheduler.addJob(jobDetail, true);  
            CronTrigger trigger = newTrigger()
            .forJob(jobDetail)
            .withIdentity(name, GROUP_1)
            .withSchedule(cronSchedule(cronExpression))
            .build();
            scheduler.scheduleJob(trigger);
            scheduler.rescheduleJob(trigger.getKey(), trigger);
            
        } catch (SchedulerException e) {  
            LoggerUtil.cLog.error(StackTraceUtil.getStackTrace(e));
            throw new LlSystemException(MessageConstants.SCHEDULE_EX);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            LoggerUtil.cLog.error(StackTraceUtil.getStackTrace(e));
            throw new LlSystemException(MessageConstants.SCHEDULE_EX);
        }  
        */
    }  
    
    public void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval) throws Exception {  
        if (name == null || name.trim().equals("")) {  
            name = UUID.randomUUID().toString();  
        }  
  /*
        try {  
            scheduler.addJob(jobDetail, true);
            SimpleTrigger trigger = (SimpleTrigger) newTrigger()
            .forJob(jobDetail)
            .withIdentity(name, GROUP_1)
            .startAt(startTime)
            .build();
            scheduler.scheduleJob(trigger);
            scheduler.rescheduleJob(trigger.getKey(), trigger);
        } catch (SchedulerException e) {  
            throw new LlSystemException(MessageConstants.SCHEDULE_EX);
        } 
        */
    }

    /** (非 Javadoc) 
    *  
    *  
    * @param name
    * @param cronExpression 
    * @see com.spring.web.schedule.SchedulerService#schedule(java.lang.String, org.quartz.CronExpression) 
    */
    public void schedule(String name, CronExpression cronExpression) {
        // TODO Auto-generated method stub
        
    }  
}
