package com.cloudeasy.model;

import java.io.Serializable;
import java.util.Date;

public class BrandNews implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.picture
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.video_url
     *
     * @mbggenerated
     */
    private String videoUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.brand_id
     *
     * @mbggenerated
     */
    private Integer brandId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.create_user
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.checker
     *
     * @mbggenerated
     */
    private String checker;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.flag
     *
     * @mbggenerated
     */
    private String flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.check_time
     *
     * @mbggenerated
     */
    private Date checkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.all_seq
     *
     * @mbggenerated
     */
    private Integer allSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.signal_seq
     *
     * @mbggenerated
     */
    private Integer signalSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.news_source
     *
     * @mbggenerated
     */
    private String newsSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.index_seq
     *
     * @mbggenerated
     */
    private Integer indexSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.content
     *
     * @mbggenerated
     */
    private String content;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.brandType
     *
     * @mbggenerated
     */
    private String brandType;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_news_tbl.schoolType
     *
     * @mbggenerated
     */
    private String schoolType;
    
    private String language;
    
    private String tags;
    
    
    public BrandNews(Integer id, String title, String picture, String videoUrl,
			Integer brandId, Date createTime, String createUser,
			String checker, String flag, Date checkTime, Integer allSeq,
			Integer signalSeq, String newsSource, Integer indexSeq,
			String content, String brandType, String schoolType,
			String language, String tags, String category) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.videoUrl = videoUrl;
		this.brandId = brandId;
		this.createTime = createTime;
		this.createUser = createUser;
		this.checker = checker;
		this.flag = flag;
		this.checkTime = checkTime;
		this.allSeq = allSeq;
		this.signalSeq = signalSeq;
		this.newsSource = newsSource;
		this.indexSeq = indexSeq;
		this.content = content;
		this.brandType = brandType;
		this.schoolType = schoolType;
		this.language = language;
		this.tags = tags;
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    private String category;//类型

    public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
	    this.category = category == null ? null : category.trim();
	}


	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    public BrandNews(Integer id, String title, String picture, String videoUrl, Integer brandId, 
    		Date createTime, String createUser, String checker, String flag, Date checkTime, 
    		Integer allSeq, Integer signalSeq, String newsSource, Integer indexSeq, 
    		String content, String brandType,String category,String schoolType,String language) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.videoUrl = videoUrl;
        this.brandId = brandId;
        this.createTime = createTime;
        this.createUser = createUser;
        this.checker = checker;
        this.flag = flag;
        this.checkTime = checkTime;
        this.allSeq = allSeq;
        this.signalSeq = signalSeq;
        this.newsSource = newsSource;
        this.indexSeq = indexSeq;
        this.content = content;
        this.brandType = brandType;
        this.category = category;
        this.schoolType = schoolType;
        this.language = language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    public BrandNews() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.id
     *
     * @return the value of brand_news_tbl.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.id
     *
     * @param id the value for brand_news_tbl.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.title
     *
     * @return the value of brand_news_tbl.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.title
     *
     * @param title the value for brand_news_tbl.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.picture
     *
     * @return the value of brand_news_tbl.picture
     *
     * @mbggenerated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.picture
     *
     * @param picture the value for brand_news_tbl.picture
     *
     * @mbggenerated
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.video_url
     *
     * @return the value of brand_news_tbl.video_url
     *
     * @mbggenerated
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.video_url
     *
     * @param videoUrl the value for brand_news_tbl.video_url
     *
     * @mbggenerated
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.brand_id
     *
     * @return the value of brand_news_tbl.brand_id
     *
     * @mbggenerated
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.brand_id
     *
     * @param brandId the value for brand_news_tbl.brand_id
     *
     * @mbggenerated
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.create_time
     *
     * @return the value of brand_news_tbl.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.create_time
     *
     * @param createTime the value for brand_news_tbl.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.create_user
     *
     * @return the value of brand_news_tbl.create_user
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.create_user
     *
     * @param createUser the value for brand_news_tbl.create_user
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.checker
     *
     * @return the value of brand_news_tbl.checker
     *
     * @mbggenerated
     */
    public String getChecker() {
        return checker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.checker
     *
     * @param checker the value for brand_news_tbl.checker
     *
     * @mbggenerated
     */
    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.flag
     *
     * @return the value of brand_news_tbl.flag
     *
     * @mbggenerated
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.flag
     *
     * @param flag the value for brand_news_tbl.flag
     *
     * @mbggenerated
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.check_time
     *
     * @return the value of brand_news_tbl.check_time
     *
     * @mbggenerated
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.check_time
     *
     * @param checkTime the value for brand_news_tbl.check_time
     *
     * @mbggenerated
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.all_seq
     *
     * @return the value of brand_news_tbl.all_seq
     *
     * @mbggenerated
     */
    public Integer getAllSeq() {
        return allSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.all_seq
     *
     * @param allSeq the value for brand_news_tbl.all_seq
     *
     * @mbggenerated
     */
    public void setAllSeq(Integer allSeq) {
        this.allSeq = allSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.signal_seq
     *
     * @return the value of brand_news_tbl.signal_seq
     *
     * @mbggenerated
     */
    public Integer getSignalSeq() {
        return signalSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.signal_seq
     *
     * @param signalSeq the value for brand_news_tbl.signal_seq
     *
     * @mbggenerated
     */
    public void setSignalSeq(Integer signalSeq) {
        this.signalSeq = signalSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.news_source
     *
     * @return the value of brand_news_tbl.news_source
     *
     * @mbggenerated
     */
    public String getNewsSource() {
        return newsSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.news_source
     *
     * @param newsSource the value for brand_news_tbl.news_source
     *
     * @mbggenerated
     */
    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.index_seq
     *
     * @return the value of brand_news_tbl.index_seq
     *
     * @mbggenerated
     */
    public Integer getIndexSeq() {
        return indexSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.index_seq
     *
     * @param indexSeq the value for brand_news_tbl.index_seq
     *
     * @mbggenerated
     */
    public void setIndexSeq(Integer indexSeq) {
        this.indexSeq = indexSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_news_tbl.content
     *
     * @return the value of brand_news_tbl.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_news_tbl.content
     *
     * @param content the value for brand_news_tbl.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BrandNews other = (BrandNews) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getVideoUrl() == null ? other.getVideoUrl() == null : this.getVideoUrl().equals(other.getVideoUrl()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getChecker() == null ? other.getChecker() == null : this.getChecker().equals(other.getChecker()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getAllSeq() == null ? other.getAllSeq() == null : this.getAllSeq().equals(other.getAllSeq()))
            && (this.getSignalSeq() == null ? other.getSignalSeq() == null : this.getSignalSeq().equals(other.getSignalSeq()))
            && (this.getNewsSource() == null ? other.getNewsSource() == null : this.getNewsSource().equals(other.getNewsSource()))
            && (this.getIndexSeq() == null ? other.getIndexSeq() == null : this.getIndexSeq().equals(other.getIndexSeq()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getBrandType() == null ? other.getBrandType() == null : this.getBrandType().equals(other.getBrandType()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getSchoolType() == null ? other.getSchoolType() == null : this.getSchoolType().equals(other.getSchoolType()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getVideoUrl() == null) ? 0 : getVideoUrl().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getChecker() == null) ? 0 : getChecker().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getAllSeq() == null) ? 0 : getAllSeq().hashCode());
        result = prime * result + ((getSignalSeq() == null) ? 0 : getSignalSeq().hashCode());
        result = prime * result + ((getNewsSource() == null) ? 0 : getNewsSource().hashCode());
        result = prime * result + ((getIndexSeq() == null) ? 0 : getIndexSeq().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getBrandType() == null) ? 0 : getBrandType().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getSchoolType() == null) ? 0 : getSchoolType().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_news_tbl
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", picture=").append(picture);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", brandId=").append(brandId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", checker=").append(checker);
        sb.append(", flag=").append(flag);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", allSeq=").append(allSeq);
        sb.append(", signalSeq=").append(signalSeq);
        sb.append(", newsSource=").append(newsSource);
        sb.append(", indexSeq=").append(indexSeq);
        sb.append(", content=").append(content);
        sb.append(", brandType=").append(brandType);
        sb.append(", category=").append(category);
        sb.append(", schoolType=").append(schoolType);
        sb.append(", language=").append(language);
        sb.append("]");
        return sb.toString();
    }
    
    public static enum BrandNewsType{//主题类别
    	
    	NEWS("news"),//新闻
    	CNEWS("cnews"),//公司新闻
    	INEWS("inews");//行业新闻
    	

    	BrandNewsType(String value) {
			this.value = value;
		}

		private final String value;

		public String toString() {
			return value;
		}
    }
}