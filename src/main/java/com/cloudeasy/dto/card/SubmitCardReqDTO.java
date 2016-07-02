/**
 * 
 */
package com.cloudeasy.dto.card;

import com.cloudeasy.dto.DTO;

/**
 * @author admin
 *
 */
public class SubmitCardReqDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1854346042358987857L;

	private String cardNo;
	
	private String username;
	
	private String userAddress;
	
	private String account;
	
	private String telephone;
	
	private String terminal;
	
	private String weixin;
	

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

}
