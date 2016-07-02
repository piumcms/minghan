package com.cloudeasy.bean;

import java.util.Date;

public class NewsBean {

	 private Integer id;

	    /**
	     * 标题
	     */
	    private String title;

	    /**
	     * 图片
	     */
	    private String picture;

	    /**
	     * 来源
	     */
	    private String newsSource;
	    
	    /**
	     * 作者
	     */
	    private String newsAuthor;

	    /**
	     * 简介
	     */
	    private String brief;

	    /**
	     * 是否审核
	     */
	    private String isCheck;

	    /**
	     * 审核人
	     */
	    private String checher;

	    /**
	     * 新闻类别名称
	     */
	    private String newsTypeName;

	    /**
	     * 审核时间
	     */
	    private Double checkTime;

	    /**
	     * 创建时间
	     */
	    private Date createTime;

	    /**
	     * 创建用户
	     */
	    private String createUser;

	    /**
	     * flag
	     */
	    private String flag;

	    /**
	     * 内容
	     */
	    private String content;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

		public String getNewsSource() {
			return newsSource;
		}

		public void setNewsSource(String newsSource) {
			this.newsSource = newsSource;
		}

		public String getNewsAuthor() {
			return newsAuthor;
		}

		public void setNewsAuthor(String newsAuthor) {
			this.newsAuthor = newsAuthor;
		}

		public String getBrief() {
			return brief;
		}

		public void setBrief(String brief) {
			this.brief = brief;
		}

		public String getIsCheck() {
			return isCheck;
		}

		public void setIsCheck(String isCheck) {
			this.isCheck = isCheck;
		}

		public String getChecher() {
			return checher;
		}

		public void setChecher(String checher) {
			this.checher = checher;
		}
	
		public String getNewsTypeName() {
			return newsTypeName;
		}

		public void setNewsTypeName(String newsTypeName) {
			this.newsTypeName = newsTypeName;
		}

		public Double getCheckTime() {
			return checkTime;
		}

		public void setCheckTime(Double checkTime) {
			this.checkTime = checkTime;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public String getCreateUser() {
			return createUser;
		}

		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
}
