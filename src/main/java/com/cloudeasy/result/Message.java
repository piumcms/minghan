/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.result;

/** 
 * @Title: Message 
 * @Description: message信息实体 
 * @author SEA   
 * @date Jun 26, 2013 6:36:07 PM 
 * @version V1.0   
 */
public class Message {
    
    private String messageId;
    
    private String[] params;
    
    public Message(String messageId, String[] params) {
        this.messageId = messageId;
        this.params = params;
    }

    /** 
     * @return messageId 
     */
    
    public String getMessageId() {
        return messageId;
    }

    /** 
     * @param messageId 要设置的 messageId 
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /** 
     * @return params 
     */
    
    public String[] getParams() {
        return params;
    }

    /** 
     * @param params 要设置的 params 
     */
    public void setParams(String[] params) {
        this.params = params;
    }
    
}
