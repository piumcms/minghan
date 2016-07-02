/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudeasy.model.Resource;
import com.cloudeasy.model.Role;
import com.cloudeasy.model.User;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;

/** 
 * @Title: LlRealm 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-18 上午10:21:25 
 * @version V1.0   
 */
@Service  
@Transactional 
public class LlRealm extends AuthorizingRealm {

	@Autowired
	private BaseDao baseDao;
	
	
	// 获取用户对象
	private static final String SQL_SELECTUSER = "index.selectByUsername";
	
	// 获取用户角色
	private static final String SQL_SELECTROLE = "index.selectRolesByUsername";
	
	//获取用户权限
	private static final String SQL_SELECTAUTH = "index.selectResourcesByRoleName";
	
	/** (非 Javadoc) 
	 *  
	 * @param arg0
	 * @return 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection) 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
        
        // 获取用户对象
        DynamicDBValues dy = baseDao.createDBValues();
        dy.put("username", loginName);
        User user = baseDao.queryForObject(SQL_SELECTUSER, dy);
        
        if(user!=null){  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            dy.put("username", loginName);
            Role role = baseDao.queryForObject(SQL_SELECTROLE, dy);
            Set<String> roleNames = new HashSet<String>();
            roleNames.add(role.getName());
            //登录的用户角色  
            info.setRoles(roleNames);
            dy.put("name", role.getName());
            dy.put("flag", role.getFlag());
            List<Resource> resourceList = baseDao.queryForList(SQL_SELECTAUTH, dy);
            
            Set<String> permissions = new HashSet<String>();  
            for(Resource r:resourceList){  
                //角色有多少个权限  
            	permissions.add(r.getUrl());
            }  
            info.addStringPermissions(permissions);
            return info;  
        }  
        return null;  
	}

	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg0
	 * @return
	 * @throws AuthenticationException 
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken) 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
	        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
	        
	        DynamicDBValues dy = baseDao.createDBValues();
	        dy.put("username", token.getUsername());
	        User user = baseDao.queryForObject(SQL_SELECTUSER, dy); 
	        if(user != null) {  
	            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), Util.bytes(user.getSalt()), getName());  
	        }  
	        return null;  
	}
}
