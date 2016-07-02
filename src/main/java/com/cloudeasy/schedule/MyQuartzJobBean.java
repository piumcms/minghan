/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** 
 * @Title: MyQuartzJobBean 
 * @Description: 触发器，执行业务逻辑
 * @author SEA   
 * @date Jun 28, 2013 1:36:03 PM 
 * @version V1.0   
 */
public class MyQuartzJobBean extends QuartzJobBean {

    /** (非 Javadoc) 
     *  
     *  
     * @param arg0
     * @throws JobExecutionException 
     * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext) 
     */
    protected void executeInternal(JobExecutionContext jobexecutioncontext)
                    throws JobExecutionException {
       
    	System.out.println("wwwwww");
    }

}
