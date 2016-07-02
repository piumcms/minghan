package com.cloudeasy.dto.news;

import com.cloudeasy.dto.BaseDTO;

/**
 * 新闻类别ReqDTO
 * @author madmai
 *
 */
public class ListNewsTypeReqDTO extends BaseDTO{

	/**
	 * 新闻编号
	 */
	private Integer id;
	
	/**
	 * 新闻类别名称
	 */
    private String categoryName;

    /**
     * 商店ID
     */
    private String flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
    
    
	
}
