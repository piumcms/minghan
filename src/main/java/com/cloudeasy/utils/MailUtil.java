/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @Title: MailUtil 
 * @Description: 邮件工具类
 * @author ZDH
 * @date 2013-9-6 下午6:00:08 
 * @version V1.0
 */
public class MailUtil {

	 /**
     * 邮件服务器
     */
    public static String EMAIL_HOST = "smtp.163.com";
//    public final static String EMAIL_HOST = "ex8.szhot.com";
    
    /**
     * email源地址
     */
    public static  String EMAIL_FROM = "zhang.da.hai@163.com";
    
    /**
     * emai用户名
     */
   public  static String EMAIL_USERNAME = "zhang.da.hai@163.com";
//    public final static String EMAIL_USERNAME = "wittc@wittc.cn";
    
    /**
     * email密码
     */
    public static String EMAIL_PASSWORD = "***********";
 //   public final static String EMAIL_PASSWORD = "ZOGJZX100";
    
    /**
     * 发件人邮箱服务器
     */
    private String sentEmailHost;
    /**
     * 发件人邮箱
     */
    private String sentEmailAddress;

    /**
     * 发件人用户名
     */
    private String sentEmailUserName;

    /**
     * 发件人密码
     */
    private String sentEmailPassword;

    /**
     * 收件人邮箱
     */
    private String[] toEmailsAddress;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String content;
    
    private static Properties prop = null;
    
    static {
    	 prop = new Properties(); 
         InputStream in = MailUtil.class.getResourceAsStream("/system.properties"); 
         try { 
             prop.load(in); 
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
    }
	
	public String getSentEmailHost() {
		if (StringUtils.isBlank(sentEmailHost)) {
			sentEmailHost = prop.getProperty("email.host").trim().toString();
		}
		return sentEmailHost;
	}

	public void setSentEmailHost(String sentEmailHost) {
		this.sentEmailHost = sentEmailHost;
	}
	
	public String getSentEmailAddress() {
		if (StringUtils.isBlank(sentEmailAddress)) {
			sentEmailAddress = prop.getProperty("email.from").trim().toString();
		}
		return sentEmailAddress;
	}
	
	public void setSentEmailAddress(String sentEmailAddress) {
		this.sentEmailAddress = sentEmailAddress;
	}

    public String getSentEmailUserName() {
    	if (StringUtils.isBlank(sentEmailUserName)) {
    		sentEmailUserName = prop.getProperty("email.username").trim().toString();
        }
		return sentEmailUserName;
	}

	public void setSentEmailUserName(String sentEmailUserName) {
		this.sentEmailUserName = sentEmailUserName;
	}

    public String getSentEmailPassword() {
    	if (StringUtils.isBlank(sentEmailPassword)) {
    		sentEmailPassword =prop.getProperty("email.password").trim().toString();
        }
		return sentEmailPassword;
	}

	public void setSentEmailPassword(String sentEmailPassword) {
		this.sentEmailPassword = sentEmailPassword;
	}

    public String[] getToEmailsAddress() {
		return toEmailsAddress;
	}

	public void setToEmailsAddress(String[] toEmailsAddress) {
		this.toEmailsAddress = toEmailsAddress;
	}

	/**
	 * @return title 
	 */
	
	public String getTitle() {
		if (StringUtils.isBlank(title)) {
        	title = "无标题";
        }
        return title;
	}

	/** 
	 * @param title 要设置的 title 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @throws Exception 
     * @throws Exception
     */
    public void sendEmail() throws Exception {
    	
        if (this.getSentEmailHost().equals("") || this.getSentEmailAddress().equals("")
                        || this.getSentEmailUserName().equals("")
                        || this.getSentEmailPassword().equals("")) {
            throw new RuntimeException("发件人信息不完全，请确认发件人信息！");
        }
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设定mail server
        senderImpl.setHost(sentEmailHost);
        // 建立邮件消息
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        // 设置收件人邮箱
        List<String> toEmailList = new ArrayList<String>();
        if (null == toEmailsAddress || toEmailsAddress.length <= 0) {
            throw new RuntimeException("收件人邮箱不得为空！");
        } else {
            for (String s : toEmailsAddress) {
                if (!s.equals("")) {
                    toEmailList.add(s);
                }
            }
            if (null == toEmailList || toEmailList.size() <= 0) {
                throw new RuntimeException("收件人邮箱不得为空！");
            } else {
            	toEmailsAddress = new String[toEmailList.size()];
                for (int i = 0; i < toEmailList.size(); i++) {
                	toEmailsAddress[i] = toEmailList.get(i);
                }
            }
        }     
        try {
            // 设置发件人邮箱
            messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            messageHelper.setFrom(sentEmailAddress);
            messageHelper.setTo(toEmailsAddress);
            // 邮件标题
            messageHelper.setSubject(title);
            // true 表示启动HTML格式的邮件
            messageHelper.setText(content, true);
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
            prop.put("mail.smtp.timeout", "25000");
            // 添加验证
            MyAuthenticator auth = new MyAuthenticator(sentEmailUserName, sentEmailPassword);
            Session session = Session.getDefaultInstance(prop, auth);
            senderImpl.setSession(session);
            StringBuffer ss = new StringBuffer();
            for(int i=0;i < toEmailsAddress.length;i++){
                if(!ss.toString().equals("")) ss.append(",");
                ss.append(toEmailsAddress[i]);
                if((i +1)%40 == 0 || (i+1) == toEmailsAddress.length ) {
                    //每40个收件人一组发送邮件
                    messageHelper.setTo(ss.toString().split(","));
                    //发送邮件
                    senderImpl.send(mailMessage);
                    ss.setLength(0);
                }
            }
        } catch (SendFailedException  e) {
            LoggerUtil.cLog.info(StackTraceUtil.getStackTrace(e));
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            LoggerUtil.cLog.info(StackTraceUtil.getStackTrace(e));
        }
    }

    public void sendEmailByException(String[] validMailStr) throws Exception {
    	
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设定mail server
        senderImpl.setHost(sentEmailHost);
        // 建立邮件消息
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");
        // 设置发件人邮箱
        messageHelper.setFrom(sentEmailAddress);
        messageHelper.setTo(validMailStr);
        // 邮件标题
        messageHelper.setSubject(title);
        // true 表示启动HTML格式的邮件
        messageHelper.setText(content, true);
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "25000");
        // 添加验证
        MyAuthenticator auth = new MyAuthenticator(sentEmailUserName, sentEmailPassword);
        Session session = Session.getDefaultInstance(prop, auth);
        senderImpl.setSession(session);
        // 发送邮件
        senderImpl.send(mailMessage);

    }
    
    
//    public static void main(String[] args) {
//    	JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
//    	// 设定mail server
//        senderImpl.setHost("ex8.szhot.com");
//        // 建立邮件消息
//        MimeMessage mailMessage = senderImpl.createMimeMessage();
//        MimeMessageHelper messageHelper = null;
//        try {
//            // 设置发件人邮箱
//            messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");
//            messageHelper.setFrom("wittc@wittc.cn");
//            messageHelper.setTo("1040723919@qq.com");
//            messageHelper.setSubject("测试");
//            messageHelper.setText("测试", true);
//            Properties prop = new Properties();
//            prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
//            prop.put("mail.smtp.timeout", "25000");
//            // 添加验证
//            MyAuthenticator auth = new MyAuthenticator("wittc@wittc.cn", "ZOGJZX100");
//            Session session = Session.getDefaultInstance(prop, auth);
//            senderImpl.setSession(session);
//            senderImpl.send(mailMessage);
//            System.out.println("321432");
//	} catch(Exception e){
//		
//	}
//    }

}
