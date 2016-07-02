/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.result;

import java.util.List;
import java.util.Map;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.dto.DTO;

/**
 * 结果基类
 * @Title: Result 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-2 下午2:40:14 
 * @version V1.0
 */
public interface Result {
	
	public void setBrandType(String brandType);
	
	public String getBrandType();
	
	public void setStatus(String status);
	
	public String getStatus();
	
	public void setMessage(String s, String[] parma);
	
	public Map<String, String[]> getMessage();
	
    public List<Message> getMessageList();

    /** 
     * @param messageList 要设置的 messageList 
     */
    public void setMessageList(Message message);
    
    /**
     * 
     * @return baseDTO
     */
    public BaseDTO getBaseDTO();
    
    /**
     * 
     * @param baseDTO 要设置的 baseDTO
     */
    public void setBaseDTO(BaseDTO baseDTO);
	/** 
     * @return dto 
     */
    
    public DTO getDto();

    /** 
     * @param dto 要设置的 dto 
     */
    public void setDto(DTO dto);
    
    /** 
     * @return obj 
     */
    
    public Object getObj();

    /** 
     * @param dto 要设置的 obj 
     */
    public void setObj(Object obj);
    
    /**
	 * @return messList 
	 */
	
	public List<Mess> getMessList();

	/** 
	 * @param mess 要设置的 messList 
	 */
	public void setMessList(Mess mess);
}
