/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @Title: MyAuthenticator 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午6:03:04 
 * @version V1.0
 */
public class MyAuthenticator extends Authenticator{

    private String username;
    private String password;

	/**
	 * 
	 *  
	 *  
	 * @param username
	 * @param password
	 */
    public MyAuthenticator(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
