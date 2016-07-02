package com.cloudeasy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


public class TagRelation implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 7628236648645839563L;
	private Integer id;
	private Integer relationId;
	private String type;
	private Integer tagId;

	
	/** 
	 *  
	 *  
	 * @param id
	 * @param relationId
	 * @param type
	 * @param tagId 
	 */ 
	
	public TagRelation(Integer id, Integer relationId, String type, Integer tagId) {
		super();
		this.id = id;
		this.relationId = relationId;
		this.type = type;
		this.tagId = tagId;
	}


	/**
	 * @return tagId 
	 */
	
	public Integer getTagId() {
		return tagId;
	}


	/** 
	 * @param tagId 要设置的 tagId 
	 */
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}


	public TagRelation(){}


	/**
	 * @return id 
	 */
	
	public Integer getId() {
		return id;
	}


	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return relationId 
	 */
	
	public Integer getRelationId() {
		return relationId;
	}


	/** 
	 * @param integer 要设置的 relationId 
	 */
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}


	/**
	 * @return type 
	 */
	
	public String getType() {
		return type;
	}


	/** 
	 * @param type 要设置的 type 
	 */
	public void setType(String type) {
		this.type = type;
	}


	/** 
	 *  
	 *  
	 * @param id
	 * @param relationId
	 * @param type 
	 */ 
	
	public TagRelation(Integer id, Integer relationId, String type) {
		super();
		this.id = id;
		this.relationId = relationId;
		this.type = type;
	}
	
	
	
}
