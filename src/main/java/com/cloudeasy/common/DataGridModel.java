package com.cloudeasy.common;

import java.util.HashMap;
import java.util.Map;


/**
 * 排序分页面参数
 * */
public class DataGridModel  implements java.io.Serializable {
	
	private static final long serialVersionUID = 7232798260610351343L;
	private int page = 1; //当前页,名字必须为page
	private int rows = 10; //每页大小,名字必须为rows
	private String sort = "id"; //排序字段
	private String order = "asc"; //排序规则
	
	private Map<String,Object> params = new HashMap<String,Object>(0);
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
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
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
}
