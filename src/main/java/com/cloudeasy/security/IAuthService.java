package com.cloudeasy.security;
/**  
 * Copyright(c)2013 Wuxi Ll Co.,Ltd. 
 * All right reserved. 
 */

/**
 * @Title: IAuthService
 * @Description: TODO
 * @author ll
 * @date 2014-1-3 下午3:07:33
 * @version V1.0
 */
public interface IAuthService {
	/**
	 * 
	 * 加载过滤配置信息
	 * 
	 * @return
	 */

	public String loadFilterChainDefinitions();

	/**
	 * 
	 * 重新构建权限过滤器
	 * 
	 * 一般在修改了用户角色、用户等信息时，需要再次调用该方法
	 */

	public void reCreateFilterChains();

}
