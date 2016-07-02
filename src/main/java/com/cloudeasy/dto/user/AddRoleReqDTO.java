/**
 * 
 */
package com.cloudeasy.dto.user;

import com.cloudeasy.dto.DTO;

/**
 * @author zoutao
 *
 */
public class AddRoleReqDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3721721015421251069L;
	
	private String flag;
	
	private String memo;
	
	private String name;
	
	private Integer id;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
