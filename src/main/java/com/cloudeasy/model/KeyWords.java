package com.cloudeasy.model;

import java.io.Serializable;

public class KeyWords implements Serializable {
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
    private String desC1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.des_c2
     *
     * @mbggenerated
     */
    private String desC2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.des_c3
     *
     * @mbggenerated
     */
    private String desC3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column key_words_tbl.flag
     *
     * @mbggenerated
     */
    private String flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    public KeyWords(Integer id, String title, String keyWords, String desC1, String desC2, String desC3, String flag) {
        this.id = id;
        this.title = title;
        this.keyWords = keyWords;
        this.desC1 = desC1;
        this.desC2 = desC2;
        this.desC3 = desC3;
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    public KeyWords() {
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
     * This method returns the value of the database column key_words_tbl.des_c1
     *
     * @return the value of key_words_tbl.des_c1
     *
     * @mbggenerated
     */
    public String getDesC1() {
        return desC1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.des_c1
     *
     * @param desC1 the value for key_words_tbl.des_c1
     *
     * @mbggenerated
     */
    public void setDesC1(String desC1) {
        this.desC1 = desC1 == null ? null : desC1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.des_c2
     *
     * @return the value of key_words_tbl.des_c2
     *
     * @mbggenerated
     */
    public String getDesC2() {
        return desC2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.des_c2
     *
     * @param desC2 the value for key_words_tbl.des_c2
     *
     * @mbggenerated
     */
    public void setDesC2(String desC2) {
        this.desC2 = desC2 == null ? null : desC2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column key_words_tbl.des_c3
     *
     * @return the value of key_words_tbl.des_c3
     *
     * @mbggenerated
     */
    public String getDesC3() {
        return desC3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column key_words_tbl.des_c3
     *
     * @param desC3 the value for key_words_tbl.des_c3
     *
     * @mbggenerated
     */
    public void setDesC3(String desC3) {
        this.desC3 = desC3 == null ? null : desC3.trim();
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
        KeyWords other = (KeyWords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getKeyWords() == null ? other.getKeyWords() == null : this.getKeyWords().equals(other.getKeyWords()))
            && (this.getDesC1() == null ? other.getDesC1() == null : this.getDesC1().equals(other.getDesC1()))
            && (this.getDesC2() == null ? other.getDesC2() == null : this.getDesC2().equals(other.getDesC2()))
            && (this.getDesC3() == null ? other.getDesC3() == null : this.getDesC3().equals(other.getDesC3()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getKeyWords() == null) ? 0 : getKeyWords().hashCode());
        result = prime * result + ((getDesC1() == null) ? 0 : getDesC1().hashCode());
        result = prime * result + ((getDesC2() == null) ? 0 : getDesC2().hashCode());
        result = prime * result + ((getDesC3() == null) ? 0 : getDesC3().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        return result;
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
        sb.append(", desC1=").append(desC1);
        sb.append(", desC2=").append(desC2);
        sb.append(", desC3=").append(desC3);
        sb.append(", flag=").append(flag);
        sb.append("]");
        return sb.toString();
    }
}