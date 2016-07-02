package com.cloudeasy.model;

import java.io.Serializable;

public class Tag implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.key_words
     *
     * @mbggenerated
     */
    private String keyWords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.des_c1
     *
     * @mbggenerated
     */
    private String des;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.des_c2
     *
     * @mbggenerated
     */
    private String falseUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.des_c3
     *
     * @mbggenerated
     */
    private String seq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.flag
     *
     * @mbggenerated
     */
    private String flag;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.flag
     *
     * @mbggenerated
     */
    private String tag;
    
    private String disabled;
    public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}


	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;



    public Tag(Integer id, String title, String keyWords, String des,
			String falseUrl, String seq, String flag, String tag,String disabled) {
		super();
		this.id = id;
		this.title = title;
		this.keyWords = keyWords;
		this.des = des;
		this.falseUrl = falseUrl;
		this.seq = seq;
		this.flag = flag;
		this.tag = tag;
		this.disabled=disabled;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getFalseUrl() {
		return falseUrl;
	}

	public void setFalseUrl(String falseUrl) {
		this.falseUrl = falseUrl;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    public Tag() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.id
     *
     * @return the value of key_words_tbl.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.id
     *
     * @param id the value for key_words_tbl.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.title
     *
     * @return the value of key_words_tbl.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.title
     *
     * @param title the value for key_words_tbl.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.key_words
     *
     * @return the value of key_words_tbl.key_words
     *
     * @mbggenerated
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.key_words
     *
     * @param keyWords the value for key_words_tbl.key_words
     *
     * @mbggenerated
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

 

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.flag
     *
     * @return the value of key_words_tbl.flag
     *
     * @mbggenerated
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.flag
     *
     * @param flag the value for key_words_tbl.flag
     *
     * @mbggenerated
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
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
        sb.append(", keyWords=").append(keyWords);
        sb.append(", des=").append(des);
        sb.append(", falseUrl=").append(falseUrl);
        sb.append(", seq=").append(seq);
        sb.append(", flag=").append(flag);
        sb.append(", tag=").append(tag);
        sb.append(", disabled=").append(disabled);
        sb.append("]");
        return sb.toString();
    }
}