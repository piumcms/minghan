/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.mybatis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 动�?参数�?
 * @Title: DynamicParameter 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:09:57 
 * @version V1.0  
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class DynamicParameter<K,V> extends HashMap implements DynamicDBValues {

	/** 
	* @Fields serialVersionUID : 序列ID 
	*/ 
	
	private static final long serialVersionUID = 7815356654851236563L;

	public Object getObject(String s) {
		// TODO Auto-generated method stub
		return super.get(s);
	}

	public String getString(String s) {
		// TODO Auto-generated method stub
		return String.valueOf(super.get(s));
	}
	
	public Boolean getBoolean(String s) {
		if (super.get(s) != null) {
			return (Boolean.valueOf(super.get(s).toString()));
		} else {
			return null;
		}
	}
	
	public Integer getInteger(String s) {
		// TODO Auto-generated method stub
		if (super.get(s) != null) {
			return (Integer.valueOf(super.get(s).toString()));
		} else {
			return null;
		}
	}
	
    public Map<?, ?> getMap(String s) {
        // TODO Auto-generated method stub
        if (super.get(s) != null) {
            return (Map<?, ?>) (super.get(s));
        } else {
            return null;
        }
    }
    
    public List<?> getList(String s) {
        // TODO Auto-generated method stub
        if (super.get(s) != null) {
            return  (List<?>) (super.get(s));
        } else {
            return null;
        }
    }
    
    /**
     * (�?Javadoc) 
     *  
     *  
     * @param s
     * @return 
     * @see com.wittc.face.ibatis.DynamicDBValues#getBigDecimal(java.lang.String)
     */
    public BigDecimal getBigDecimal(String s) {
        
        if (super.get(s) != null) {
            return (new BigDecimal(super.get(s).toString()));
        } else {
            return null;
        }
    }

	/** (�?Javadoc) 
	 *  
	 *  
	 * @return 
	 * @see com.wittc.face.ibatis.DynamicDBValues#uuid() 
	 */
	public String uuid() {
		String uuid = UUID.randomUUID().toString();
        return uuid = uuid.replace("-", "");
	}
}
