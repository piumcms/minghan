package com.cloudeasy.dto.news;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.NewsType;

/**
 * 新闻类别ResDTO
 * @author madmai
 *
 */
public class ListNewsTypeResDTO extends BaseDTO{

	/**
	 * 新闻编号
	 */
	private String id;
	
	/**
	 * 新闻类别名称
	 */
    private String categoryName;

    /**
     * 商店ID
     */
    private String flag;

    /**
     * 新闻类别列表
     */
    private List<NewsType> list;

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

	public List<NewsType> getList() {
		return list;
	}

	public void setList(List<NewsType> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	} 
}
