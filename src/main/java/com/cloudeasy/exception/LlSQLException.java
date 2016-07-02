/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.exception;
import java.sql.SQLException;
import java.util.Collection;

/**
 * 自定义sql异常
 * @Title: LlSQLException 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-2 下午2:38:54 
 * @version V1.0
 */
public class LlSQLException extends SQLException {

  /**
   * @Fields serialVersionUID : 序列Id
   */
  private static final long serialVersionUID = -228940273905131641L;

  private String messageId;

  private String[] params;

  private Collection<String> messages;


  public LlSQLException(String messageId, String params) {
    this.messageId = messageId;
    this.params = (new String[] { params });
  }

  public LlSQLException(String messageId) {
    this.messageId = messageId;
  }

  public LlSQLException(Collection<String> messages) {
    this.messages = messages;
  }

  public String getMessageId() {
    return messageId;
  }

  public String[] getParams() {
    if (params == null) {
      return null;
    } else {
      String[] results = new String[params.length];
      System.arraycopy(params, 0, results, 0, params.length);
      return results;
    }
  }

  public LlSQLException(String messageId, String[] params) {
    this.messageId = messageId;
    if (params == null) {
      this.params = null;
    } else {
      this.params = new String[params.length];
      System.arraycopy(params, 0, this.params, 0, params.length);
    }
  }
  
  public Collection<String> getMessages() {
    return messages;
  }
}
