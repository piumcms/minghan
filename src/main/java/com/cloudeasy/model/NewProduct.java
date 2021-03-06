package com.cloudeasy.model;

import java.io.Serializable;

public class NewProduct implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_product_tbl.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_product_tbl.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_product_tbl.image
     *
     * @mbggenerated
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_product_tbl.url
     *
     * @mbggenerated
     */
    private String url;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_product_tbl.brandType
     *
     * @mbggenerated
     */
    private String brandType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    public NewProduct(Integer id, String name, String image, String url, String brandType) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.url = url;
        this.brandType = brandType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_product_tbl.brandType
     *
     * @return the value of new_product_tbl.brandType
     *
     * @mbggenerated
     */
    public String getBrandType() {
		return brandType;
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_product_tbl.brandType
     *
     * @param name the value for new_product_tbl.brandType
     *
     * @mbggenerated
     */
	public void setBrandType(String brandType) {
		this.brandType = brandType == null ? null : brandType.trim();
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    public NewProduct() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_product_tbl.id
     *
     * @return the value of new_product_tbl.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_product_tbl.id
     *
     * @param id the value for new_product_tbl.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_product_tbl.name
     *
     * @return the value of new_product_tbl.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_product_tbl.name
     *
     * @param name the value for new_product_tbl.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_product_tbl.image
     *
     * @return the value of new_product_tbl.image
     *
     * @mbggenerated
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_product_tbl.image
     *
     * @param image the value for new_product_tbl.image
     *
     * @mbggenerated
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_product_tbl.url
     *
     * @return the value of new_product_tbl.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_product_tbl.url
     *
     * @param url the value for new_product_tbl.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
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
        NewProduct other = (NewProduct) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getBrandType() == null ? other.getBrandType() == null : this.getBrandType().equals(other.getBrandType()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getBrandType() == null) ? 0 : getBrandType().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
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
        sb.append(", name=").append(name);
        sb.append(", image=").append(image);
        sb.append(", url=").append(url);
        sb.append(", brandType=").append(brandType);
        sb.append("]");
        return sb.toString();
    }
}