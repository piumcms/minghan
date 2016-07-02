/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.result;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.dto.DTO;

/**
 * 结果实现类
 * @Title: ResultImpl 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-2 下午2:40:50 
 * @version V1.0
 */
public class ResultImpl implements Result {
	
	private String brandType;

	/**
	 * response DTO
	 */
	private DTO dto;
	
	private Object obj;
	
	private Map<String, String[]> message = new LinkedHashMap<String, String[]>();
	
	private List<Message> messageList = new ArrayList<Message>();
	
	/**
	 * 结果返回状态0:success,1:fail。
	 */
	private String status = "0";
	
	/**
	 * 结果DTO
	 */
	private BaseDTO baseDTO;
	
	private List<Mess> messList = new ArrayList<Mess>();
	

	public void setMessage(String s, String[] parma) {
		
		this.message.put(s, parma);
	}

	public Map<String, String[]> getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	
	/** 
     * @return dto 
     */
    
    public DTO getDto() {
        return dto;
    }

    /** 
     * @param dto 要设置的 dto 
     */
    public void setDto(DTO dto) {
        this.dto = dto;
    }
	
    /**
	 * @return obj 
	 */
	
	public Object getObj() {
		return obj;
	}

	/** 
	 * @param obj 要设置的 obj 
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/** 
     * @return messageList 
     */
    
    public List<Message> getMessageList() {
        return messageList;
    }

    /** 
     * @param messageList 要设置的 messageList 
     */
    public void setMessageList(Message message) {
        
        this.messageList.add(message);
    }

	/**
	 * @return messList 
	 */
	
	public List<Mess> getMessList() {
		return messList;
	}

	/** 
	 * @param messList 要设置的 messList 
	 */
	public void setMessList(Mess mess) {
		this.messList.add(mess);
	}

	/**
	 * @return baseDTO 
	 */
	
	public BaseDTO getBaseDTO() {
		return baseDTO;
	}

	/** 
	 * @param baseDTO 要设置的 baseDTO 
	 */
	public void setBaseDTO(BaseDTO baseDTO) {
		this.baseDTO = baseDTO;
	}

	@Override
	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	@Override
	public String getBrandType() {
		return brandType;
	}
}
