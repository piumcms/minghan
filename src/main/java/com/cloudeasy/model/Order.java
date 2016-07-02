package com.cloudeasy.model;

import java.util.Date;

public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.totalproduct
     *
     * @mbggenerated
     */
    private Double totalproduct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.totaltax
     *
     * @mbggenerated
     */
    private Double totaltax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.totalshipping
     *
     * @mbggenerated
     */
    private Double totalshipping;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.totaltaxshipping
     *
     * @mbggenerated
     */
    private Double totaltaxshipping;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.timeplaced
     *
     * @mbggenerated
     */
    private Date timeplaced;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.lastupdate
     *
     * @mbggenerated
     */
    private Date lastupdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.field1
     *
     * @mbggenerated
     */
    private Short field1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.address_id
     *
     * @mbggenerated
     */
    private Long addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.field3
     *
     * @mbggenerated
     */
    private String field3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.totaladjustment
     *
     * @mbggenerated
     */
    private Double totaladjustment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.is_coupon
     *
     * @mbggenerated
     */
    private Short isCoupon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.coupon_code
     *
     * @mbggenerated
     */
    private String couponCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.c_money
     *
     * @mbggenerated
     */
    private Double cMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.is_unicode
     *
     * @mbggenerated
     */
    private Short isUnicode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.unicode
     *
     * @mbggenerated
     */
    private String unicode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.u_money
     *
     * @mbggenerated
     */
    private Double uMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.invoice
     *
     * @mbggenerated
     */
    private String invoice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_tbl.leaMess
     *
     * @mbggenerated
     */
    private String leamess;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_tbl
     *
     * @mbggenerated
     */
    public Order(Integer id, Double totalproduct, Double totaltax, Double totalshipping, Double totaltaxshipping, Date timeplaced, Date lastupdate, String status, Integer userId, Short field1, Long addressId, String field3, Double totaladjustment, Short isCoupon, String couponCode, Double cMoney, Short isUnicode, String unicode, Double uMoney, String invoice, String leamess) {
        this.id = id;
        this.totalproduct = totalproduct;
        this.totaltax = totaltax;
        this.totalshipping = totalshipping;
        this.totaltaxshipping = totaltaxshipping;
        this.timeplaced = timeplaced;
        this.lastupdate = lastupdate;
        this.status = status;
        this.userId = userId;
        this.field1 = field1;
        this.addressId = addressId;
        this.field3 = field3;
        this.totaladjustment = totaladjustment;
        this.isCoupon = isCoupon;
        this.couponCode = couponCode;
        this.cMoney = cMoney;
        this.isUnicode = isUnicode;
        this.unicode = unicode;
        this.uMoney = uMoney;
        this.invoice = invoice;
        this.leamess = leamess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_tbl
     *
     * @mbggenerated
     */
    public Order() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.id
     *
     * @return the value of order_tbl.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.id
     *
     * @param id the value for order_tbl.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.totalproduct
     *
     * @return the value of order_tbl.totalproduct
     *
     * @mbggenerated
     */
    public Double getTotalproduct() {
        return totalproduct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.totalproduct
     *
     * @param totalproduct the value for order_tbl.totalproduct
     *
     * @mbggenerated
     */
    public void setTotalproduct(Double totalproduct) {
        this.totalproduct = totalproduct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.totaltax
     *
     * @return the value of order_tbl.totaltax
     *
     * @mbggenerated
     */
    public Double getTotaltax() {
        return totaltax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.totaltax
     *
     * @param totaltax the value for order_tbl.totaltax
     *
     * @mbggenerated
     */
    public void setTotaltax(Double totaltax) {
        this.totaltax = totaltax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.totalshipping
     *
     * @return the value of order_tbl.totalshipping
     *
     * @mbggenerated
     */
    public Double getTotalshipping() {
        return totalshipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.totalshipping
     *
     * @param totalshipping the value for order_tbl.totalshipping
     *
     * @mbggenerated
     */
    public void setTotalshipping(Double totalshipping) {
        this.totalshipping = totalshipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.totaltaxshipping
     *
     * @return the value of order_tbl.totaltaxshipping
     *
     * @mbggenerated
     */
    public Double getTotaltaxshipping() {
        return totaltaxshipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.totaltaxshipping
     *
     * @param totaltaxshipping the value for order_tbl.totaltaxshipping
     *
     * @mbggenerated
     */
    public void setTotaltaxshipping(Double totaltaxshipping) {
        this.totaltaxshipping = totaltaxshipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.timeplaced
     *
     * @return the value of order_tbl.timeplaced
     *
     * @mbggenerated
     */
    public Date getTimeplaced() {
        return timeplaced;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.timeplaced
     *
     * @param timeplaced the value for order_tbl.timeplaced
     *
     * @mbggenerated
     */
    public void setTimeplaced(Date timeplaced) {
        this.timeplaced = timeplaced;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.lastupdate
     *
     * @return the value of order_tbl.lastupdate
     *
     * @mbggenerated
     */
    public Date getLastupdate() {
        return lastupdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.lastupdate
     *
     * @param lastupdate the value for order_tbl.lastupdate
     *
     * @mbggenerated
     */
    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.status
     *
     * @return the value of order_tbl.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.status
     *
     * @param status the value for order_tbl.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.user_id
     *
     * @return the value of order_tbl.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.user_id
     *
     * @param userId the value for order_tbl.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.field1
     *
     * @return the value of order_tbl.field1
     *
     * @mbggenerated
     */
    public Short getField1() {
        return field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.field1
     *
     * @param field1 the value for order_tbl.field1
     *
     * @mbggenerated
     */
    public void setField1(Short field1) {
        this.field1 = field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.address_id
     *
     * @return the value of order_tbl.address_id
     *
     * @mbggenerated
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.address_id
     *
     * @param addressId the value for order_tbl.address_id
     *
     * @mbggenerated
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.field3
     *
     * @return the value of order_tbl.field3
     *
     * @mbggenerated
     */
    public String getField3() {
        return field3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.field3
     *
     * @param field3 the value for order_tbl.field3
     *
     * @mbggenerated
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.totaladjustment
     *
     * @return the value of order_tbl.totaladjustment
     *
     * @mbggenerated
     */
    public Double getTotaladjustment() {
        return totaladjustment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.totaladjustment
     *
     * @param totaladjustment the value for order_tbl.totaladjustment
     *
     * @mbggenerated
     */
    public void setTotaladjustment(Double totaladjustment) {
        this.totaladjustment = totaladjustment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.is_coupon
     *
     * @return the value of order_tbl.is_coupon
     *
     * @mbggenerated
     */
    public Short getIsCoupon() {
        return isCoupon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.is_coupon
     *
     * @param isCoupon the value for order_tbl.is_coupon
     *
     * @mbggenerated
     */
    public void setIsCoupon(Short isCoupon) {
        this.isCoupon = isCoupon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.coupon_code
     *
     * @return the value of order_tbl.coupon_code
     *
     * @mbggenerated
     */
    public String getCouponCode() {
        return couponCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.coupon_code
     *
     * @param couponCode the value for order_tbl.coupon_code
     *
     * @mbggenerated
     */
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.c_money
     *
     * @return the value of order_tbl.c_money
     *
     * @mbggenerated
     */
    public Double getcMoney() {
        return cMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.c_money
     *
     * @param cMoney the value for order_tbl.c_money
     *
     * @mbggenerated
     */
    public void setcMoney(Double cMoney) {
        this.cMoney = cMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.is_unicode
     *
     * @return the value of order_tbl.is_unicode
     *
     * @mbggenerated
     */
    public Short getIsUnicode() {
        return isUnicode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.is_unicode
     *
     * @param isUnicode the value for order_tbl.is_unicode
     *
     * @mbggenerated
     */
    public void setIsUnicode(Short isUnicode) {
        this.isUnicode = isUnicode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.unicode
     *
     * @return the value of order_tbl.unicode
     *
     * @mbggenerated
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.unicode
     *
     * @param unicode the value for order_tbl.unicode
     *
     * @mbggenerated
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode == null ? null : unicode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.u_money
     *
     * @return the value of order_tbl.u_money
     *
     * @mbggenerated
     */
    public Double getuMoney() {
        return uMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.u_money
     *
     * @param uMoney the value for order_tbl.u_money
     *
     * @mbggenerated
     */
    public void setuMoney(Double uMoney) {
        this.uMoney = uMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.invoice
     *
     * @return the value of order_tbl.invoice
     *
     * @mbggenerated
     */
    public String getInvoice() {
        return invoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.invoice
     *
     * @param invoice the value for order_tbl.invoice
     *
     * @mbggenerated
     */
    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_tbl.leaMess
     *
     * @return the value of order_tbl.leaMess
     *
     * @mbggenerated
     */
    public String getLeamess() {
        return leamess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_tbl.leaMess
     *
     * @param leamess the value for order_tbl.leaMess
     *
     * @mbggenerated
     */
    public void setLeamess(String leamess) {
        this.leamess = leamess == null ? null : leamess.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_tbl
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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTotalproduct() == null ? other.getTotalproduct() == null : this.getTotalproduct().equals(other.getTotalproduct()))
            && (this.getTotaltax() == null ? other.getTotaltax() == null : this.getTotaltax().equals(other.getTotaltax()))
            && (this.getTotalshipping() == null ? other.getTotalshipping() == null : this.getTotalshipping().equals(other.getTotalshipping()))
            && (this.getTotaltaxshipping() == null ? other.getTotaltaxshipping() == null : this.getTotaltaxshipping().equals(other.getTotaltaxshipping()))
            && (this.getTimeplaced() == null ? other.getTimeplaced() == null : this.getTimeplaced().equals(other.getTimeplaced()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getField1() == null ? other.getField1() == null : this.getField1().equals(other.getField1()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getField3() == null ? other.getField3() == null : this.getField3().equals(other.getField3()))
            && (this.getTotaladjustment() == null ? other.getTotaladjustment() == null : this.getTotaladjustment().equals(other.getTotaladjustment()))
            && (this.getIsCoupon() == null ? other.getIsCoupon() == null : this.getIsCoupon().equals(other.getIsCoupon()))
            && (this.getCouponCode() == null ? other.getCouponCode() == null : this.getCouponCode().equals(other.getCouponCode()))
            && (this.getcMoney() == null ? other.getcMoney() == null : this.getcMoney().equals(other.getcMoney()))
            && (this.getIsUnicode() == null ? other.getIsUnicode() == null : this.getIsUnicode().equals(other.getIsUnicode()))
            && (this.getUnicode() == null ? other.getUnicode() == null : this.getUnicode().equals(other.getUnicode()))
            && (this.getuMoney() == null ? other.getuMoney() == null : this.getuMoney().equals(other.getuMoney()))
            && (this.getInvoice() == null ? other.getInvoice() == null : this.getInvoice().equals(other.getInvoice()))
            && (this.getLeamess() == null ? other.getLeamess() == null : this.getLeamess().equals(other.getLeamess()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_tbl
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTotalproduct() == null) ? 0 : getTotalproduct().hashCode());
        result = prime * result + ((getTotaltax() == null) ? 0 : getTotaltax().hashCode());
        result = prime * result + ((getTotalshipping() == null) ? 0 : getTotalshipping().hashCode());
        result = prime * result + ((getTotaltaxshipping() == null) ? 0 : getTotaltaxshipping().hashCode());
        result = prime * result + ((getTimeplaced() == null) ? 0 : getTimeplaced().hashCode());
        result = prime * result + ((getLastupdate() == null) ? 0 : getLastupdate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getField1() == null) ? 0 : getField1().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getField3() == null) ? 0 : getField3().hashCode());
        result = prime * result + ((getTotaladjustment() == null) ? 0 : getTotaladjustment().hashCode());
        result = prime * result + ((getIsCoupon() == null) ? 0 : getIsCoupon().hashCode());
        result = prime * result + ((getCouponCode() == null) ? 0 : getCouponCode().hashCode());
        result = prime * result + ((getcMoney() == null) ? 0 : getcMoney().hashCode());
        result = prime * result + ((getIsUnicode() == null) ? 0 : getIsUnicode().hashCode());
        result = prime * result + ((getUnicode() == null) ? 0 : getUnicode().hashCode());
        result = prime * result + ((getuMoney() == null) ? 0 : getuMoney().hashCode());
        result = prime * result + ((getInvoice() == null) ? 0 : getInvoice().hashCode());
        result = prime * result + ((getLeamess() == null) ? 0 : getLeamess().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_tbl
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
        sb.append(", totalproduct=").append(totalproduct);
        sb.append(", totaltax=").append(totaltax);
        sb.append(", totalshipping=").append(totalshipping);
        sb.append(", totaltaxshipping=").append(totaltaxshipping);
        sb.append(", timeplaced=").append(timeplaced);
        sb.append(", lastupdate=").append(lastupdate);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", field1=").append(field1);
        sb.append(", addressId=").append(addressId);
        sb.append(", field3=").append(field3);
        sb.append(", totaladjustment=").append(totaladjustment);
        sb.append(", isCoupon=").append(isCoupon);
        sb.append(", couponCode=").append(couponCode);
        sb.append(", cMoney=").append(cMoney);
        sb.append(", isUnicode=").append(isUnicode);
        sb.append(", unicode=").append(unicode);
        sb.append(", uMoney=").append(uMoney);
        sb.append(", invoice=").append(invoice);
        sb.append(", leamess=").append(leamess);
        sb.append("]");
        return sb.toString();
    }
}