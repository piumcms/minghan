/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.apache.commons.lang3.StringUtils;

/** 
 * @Title: NotEmptyTag 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-2 下午1:38:21 
 * @version V1.0   
 */
public class NotEmptyTag extends ConditionalTagSupport {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6514519355546961609L;
	
	private String value;
	
  public NotEmptyTag() {
        super();
        init();
    }

    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }

	/** (非 Javadoc) 
	 *  
	 *  
	 * @return
	 * @throws JspTagException 
	 * @see javax.servlet.jsp.jstl.core.ConditionalTagSupport#condition() 
	 */
	@Override
	protected boolean condition() throws JspTagException {
		// TODO Auto-generated method stub
		
		if (StringUtils.isNotBlank(value)) {
			return true;
		}
		
		return false;
	}

	 private void init() {
		 value = null;
	    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	 
}
