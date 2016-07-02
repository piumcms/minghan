/**
 * 
 */
package com.cloudeasy.dto.user;

import com.cloudeasy.dto.DTO;

/**
 * @author zdh
 *
 */
public class SaveAuthoritesReqDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7801057799655299601L;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	private String memo;
	
	private String name;
	
	private Integer id;
	
	/**
	 * 权限ids
	 */
	private String ids;
	
	/**
	 * 全局标志字段
	 */
	private String flag;
	
	/**
	 * 填写用户名
	 */
	private String username;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
