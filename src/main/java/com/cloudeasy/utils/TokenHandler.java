/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.utils;

import java.util.UUID;

/** 
 * @Title: TokenHandler 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-13 下午6:05:03 
 * @version V1.0   
 */
public class TokenHandler {

    public synchronized static String generateGUID() {

      String uuid = UUID.randomUUID().toString();
        return uuid = uuid.replace("-", "");
    }

}
