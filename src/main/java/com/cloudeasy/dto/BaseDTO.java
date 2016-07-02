/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */

package com.cloudeasy.dto;

import org.apache.commons.lang3.StringUtils;

import com.cloudeasy.bean.Pager;

/**
 * @Title: BaseDTO
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 下午4:21:12
 * @version V1.0
 */
public class BaseDTO {

	private Integer pageNumber = 1;

	private Integer rows = 10;

	private String sort;

	private String order;
	
	private Integer totalRows;
	
	private String 	brandType;//子品牌类别 详见Constants BrandType
	
	private String language;

	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();

	public Pager getPager() {
		pager.setPageId(getPageNumber());
		pager.setPageSize(getRows());
		String orderField = "";
		if (StringUtils.isNotBlank(sort)) {
			orderField = sort;
		}
		if (StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(order)) {
			orderField += " " + order;
		}
		pager.setOrderField(orderField);
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		if (pageNumber == null) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
	
}
