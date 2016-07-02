package com.cloudeasy.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cloudeasy.model.Role;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;


/**  
 * Copyright(c)2013 Wuxi Ll Co.,Ltd. 
 * All right reserved. 
 */

/** 
 * @Title: AuthServiceImpl 
 * @Description: TODO
 * @author ll
 * @date 2014-1-3 下午3:09:25 
 * @version V1.0   
 */
@Service("authService")
public class AuthServiceImpl implements IAuthService {

	
	 private static final Logger log= Logger.getLogger(AuthServiceImpl.class);

	    //注意/r/n前不能有空格

	    private static final String CRLF= "\r\n";

	    private static final String LAST_AUTH_STR = "/** =authc\r\n";
	    
	    private static final String SEARCH_ALL_ROLE_SQLID = "index.selectAllRoles";
		
		private static final String SEARCH_ALL_RESOURCE_SQLID = "index.selectResourcesByRoleName";

	    @Resource
	    private ShiroFilterFactoryBean shiroFilterFactoryBean;
	    @Resource
	    private BaseDao baseDao;

	 

	/** (非 Javadoc) 
	 *  
	 *  
	 * @return 
	 * @see IAuthService#loadFilterChainDefinitions() 
	 */
	@Override
	public String loadFilterChainDefinitions() {
		
		  StringBuffer sb = new StringBuffer("");

	       sb.append(getFixedAuthRule())

	       .append(getDynaAuthRule());

	       //.append(getRestfulOperationAuthRule())

//	       .append(LAST_AUTH_STR);
	       return sb.toString();
	}

	/*//生成restful风格功能权限规则
    private String getRestfulOperationAuthRule() {


       List<Operation> operations = dao.queryEntitys("from Operation o", new Object[]{});

       Set<String> restfulUrls = new HashSet<String>();

       for(Operation op : operations) {

           restfulUrls.add(op.getUrl());

       }

       StringBuffer sb  = new StringBuffer("");
       for(Iterator<String> urls =  restfulUrls.iterator(); urls.hasNext(); ) {

           String url = urls.next();

           if(! url.startsWith("/")) {

              url = "/"+ url ;

           }

           sb.append(url).append("=").append("authc, rest[").append(url).append("]").append(CRLF);

       }

       return sb.toString();

    }*/


    private String getDynaAuthRule() {

       StringBuffer sb = new StringBuffer("");
       Map<String, Set<String>> rules = new HashMap<String, Set<String>>();
       
       DynamicDBValues	dynamicDBValues = baseDao.createDBValues();
       
		List<Role> roles = baseDao.queryForList(SEARCH_ALL_ROLE_SQLID, dynamicDBValues);
		
		for (Role role : roles) {
			dynamicDBValues.put("name", role.getName());
			
			List<com.cloudeasy.model.Resource> resources = baseDao.queryForList(SEARCH_ALL_RESOURCE_SQLID, dynamicDBValues);
			
			for (com.cloudeasy.model.Resource resource : resources) {
				String url = resource.getUrl();
				if (!rules.containsKey(url)) {
					rules.put(url, new HashSet<String>());
				}
				rules.get(url).add(role.getName());
			}
			
		}
		
       for(Map.Entry<String, Set<String>> entry :rules.entrySet()) {

           sb.append(entry.getKey()).append(" = ").append("authc,anyofroles").append(entry.getValue()).append(CRLF);

       }

       return sb.toString();
    }

    private String getFixedAuthRule() {

       StringBuffer sb = new StringBuffer("");
       ClassPathResource cp = new ClassPathResource("fixed_auth_res.properties");
       Properties properties = new Properties();
       try{
           properties.load(cp.getInputStream());
       } catch(IOException e) {
           log.error("loadfixed_auth_res.properties error!", e);
           throw new RuntimeException("load fixed_auth_res.properties error!");

       }

       for(Iterator its = properties.keySet().iterator();its.hasNext();) {
           String key = (String)its.next();
           sb.append(key).append(" = ").append(properties.getProperty(key).trim()).append(CRLF);

       }      
       return sb.toString();
    }

	/** (非 Javadoc) 
	 *  
	 *   
	 * @see IAuthService#reCreateFilterChains() 
	 */
	@Override
	public void reCreateFilterChains() {
		 AbstractShiroFilter shiroFilter = null;

	       try{

	           shiroFilter = (AbstractShiroFilter)shiroFilterFactoryBean.getObject();

	       } catch(Exception e) {

	           log.error("getShiroFilter from shiroFilterFactoryBean error!", e);

	           throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");

	       }

	       PathMatchingFilterChainResolver filterChainResolver =(PathMatchingFilterChainResolver)shiroFilter.getFilterChainResolver();
	       DefaultFilterChainManager manager =(DefaultFilterChainManager)filterChainResolver.getFilterChainManager();

	       //清空老的权限控制
	       manager.getFilterChains().clear();

	       shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
	       shiroFilterFactoryBean.setFilterChainDefinitions(loadFilterChainDefinitions());
	       //重新构建生成

	       Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();

	        for(Map.Entry<String, String> entry :chains.entrySet()) {

	            String url = entry.getKey();

	            String chainDefinition =entry.getValue().trim().replace(" ", "");

	            manager.createChain(url,chainDefinition);
	        }
	}

}
