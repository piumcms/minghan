package com.cloudeasy.model;

import java.io.Serializable;
import java.util.Date;

public class InnovateWithBLOBs extends Innovate implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innovate_tbl.content_a
     *
     * @mbggenerated
     */
    private String contentA;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innovate_tbl.content_b
     *
     * @mbggenerated
     */
    private String contentB;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table innovate_tbl
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table innovate_tbl
     *
     * @mbggenerated
     */
    public InnovateWithBLOBs(Integer id, String createUser, Date createTime, String flag, String contentA, String contentB) {
        super(id, createUser, createTime, flag);
        this.contentA = contentA;
        this.contentB = contentB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table innovate_tbl
     *
     * @mbggenerated
     */
    public InnovateWithBLOBs() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innovate_tbl.content_a
     *
     * @return the value of innovate_tbl.content_a
     *
     * @mbggenerated
     */
    public String getContentA() {
        return contentA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innovate_tbl.content_a
     *
     * @param contentA the value for innovate_tbl.content_a
     *
     * @mbggenerated
     */
    public void setContentA(String contentA) {
        this.contentA = contentA == null ? null : contentA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innovate_tbl.content_b
     *
     * @return the value of innovate_tbl.content_b
     *
     * @mbggenerated
     */
    public String getContentB() {
        return contentB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innovate_tbl.content_b
     *
     * @param contentB the value for innovate_tbl.content_b
     *
     * @mbggenerated
     */
    public void setContentB(String contentB) {
        this.contentB = contentB == null ? null : contentB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table innovate_tbl
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
        InnovateWithBLOBs other = (InnovateWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getContentA() == null ? other.getContentA() == null : this.getContentA().equals(other.getContentA()))
            && (this.getContentB() == null ? other.getContentB() == null : this.getContentB().equals(other.getContentB()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table innovate_tbl
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getContentA() == null) ? 0 : getContentA().hashCode());
        result = prime * result + ((getContentB() == null) ? 0 : getContentB().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table innovate_tbl
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contentA=").append(contentA);
        sb.append(", contentB=").append(contentB);
        sb.append("]");
        return sb.toString();
    }
}