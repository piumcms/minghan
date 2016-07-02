/**  
* Copyright(c)2013 Wuxi ll Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.utils;

/**
 * @Title: Constants 
 * @Description: 常量定义
 * @author ZDH
 * @date 2013-9-6 下午5:52:49 
 * @version V1.0
 */
public class Constants {
    
	/**
	 * 管理员
	 */
	public static final String ROLE_ADMIN_TYPE = "0";
	
	 /***
     * 分页标签(1)
     */
    public final static Integer ONE_PAGE = 1;
    
    /**
     * 分页标签(3)
     */
    public final static Integer THREE_PAGE = 3;
    
    /**
     * 分页标签(4)
     */    
    public final static Integer FOUR_PAGE = 4;
    
    /**
     * 分页标签(8)
     */
    public final static Integer EIGHT_PAGE = 8;
    
    /**
     * 分页标签(9)
     */
    public final static Integer NINE_PAGE = 9;
    
    /**
     * 分页标签(10)
     */
    public final static Integer TEN_PAGE = 10;
    
    /**
     * 分页标签(13)
     */
    public final static Integer THIRTEEN_PAGE = 13;
    
    /**
     * 分页标签(13)
     */
    public final static Integer FOURTEEN_PAGE = 14;
    
    /**
     * 分页标签(11)
     */
    public final static Integer ELEVEN_PAGE = 11;
    
    /**
     * 分页标签(6)
     */
    public final static Integer SIX_PAGE = 6;
    
    /**
     * 分页标签(7)
     */
    public final static Integer SEVEN_PAGE = 7;
    /**
     * 样式禁用
     */
    public final static String ZERO_TAG = "0";
    
    /**
     * 样式启用
     */
    public final static String ONE_TAG = "1";
    
    public final static String NEWS_OFFSET = "5";
    
    public final static String SCHOOL_OFFSET = "300";
    
    /**
     * 上传文件message
     */
    public final static String UPLOAD_MESSAGE_001 = "file.not.empty";

    /**
     * 上传文件非法。
     */
    public final static String UPLOAD_FILE_ILLEGAL = "file.illegal";
    
    /**
     * 上传文件路径为空。
     */
    public final static String UPLOAD_FILE_PATH_EMPTY = "file.path.empth";
    
    /**
     * 上传文件目录不存在
     */
    public final static String UPLOAD_FILE_UPLOAD_EX = "file.io.error";
    
    /**
     * 系统异常。
     */
    public final static String SYSTEM_EX = "system.ex";
    
    public static final String TOTAL = "total";
    public static final String ROWS  = "rows";
    public static final String LIST	 = "list";
    public static final Integer PRODUCT_OFFSET = 10;
	
    
    public static enum BrandType{//品牌类型
    	CHEERWIN("cheerwin"),//超威日化
    	SUPERB("superb"),//超威
		BEIBEIJ("beibeij"),//贝贝健
		XILAN("xilan"),//西兰
		VEWIN("vewin"),//威王
		CMCCSOFT("cmccsoft"),//中能云盛
		ZKMED("zkmed"),//泽康医疗
		VITZRO("vitzro"),//飞世龙
    	MINGHAN("minghan");//明翰

    	BrandType(String value) {
			this.value = value;
		}

		private final String value;

		public String toString() {
			return value;
		}
    }
    
    private static enum BrandName{//品牌类型
    	CHEERWIN("cheerwin"),//超威日化
    	SUPERB("superb"),//超威
		BEIBEIJ("beibeij"),//贝贝健
		XILAN("xilan"),//西兰
		VEWIN("vewin");//威王

    	BrandName(String value) {
			this.value = value;
		}

		private final String value;

		public String toString() {
			return value;
		}
    }
    
    public static final String SELECT_LANGUAGE = "language";
}
