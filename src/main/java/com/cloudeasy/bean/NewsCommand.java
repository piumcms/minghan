/**
 * 
 */
package com.cloudeasy.bean;

import com.cloudeasy.model.News;

/**
 * @author zoutao
 *
 */
public class NewsCommand extends News {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1455152998537168263L;
	
	private String toMedia;
	
	private String toBrandNews;

	public String getToMedia() {
		return toMedia;
	}

	public void setToMedia(String toMedia) {
		this.toMedia = toMedia;
	}

	public String getToBrandNews() {
		return toBrandNews;
	}

	public void setToBrandNews(String toBrandNews) {
		this.toBrandNews = toBrandNews;
	}
	
	

}
