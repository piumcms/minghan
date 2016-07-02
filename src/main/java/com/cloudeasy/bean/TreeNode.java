package com.cloudeasy.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloudeasy.model.Category;
import com.cloudeasy.model.Resource;

public class TreeNode {

	private String id;
	
	private Integer dataId;
	
	private String text;
	
	private String url;
	
	private String state;//value closed,open
	
	private boolean checked; //
	
	private Integer parentId;
	
	private Map<String,Object> attributes = new HashMap<String, Object>(0);
	
	private List<TreeNode>  children = new ArrayList<TreeNode>(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public  Integer getParentId() {
		return parentId;
	}

	public void setParentId( Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public static List<TreeNode> getTreeNodes(List<Resource> list,Set<Integer> choosedSet){
		List<TreeNode> trees = new ArrayList<TreeNode>(0);
		TreeNode treeNode = null;
		for(Iterator<Resource> iter = list.iterator();iter.hasNext();){
			Resource r = iter.next();
			if (r.getParentId() == 0) {
				treeNode = getTreeNode(r);
				if (null!=choosedSet&&choosedSet.contains(r.getId())) {
					treeNode.setChecked(true);
				} else {
					treeNode.setChecked(false);
				}
				trees.add(treeNode);
				iter.remove();
			}
		}
		
		System.out.println("iter.size;"+list.size());
		for(TreeNode t:trees){
			for(Iterator<Resource> iter2 = list.iterator();iter2.hasNext();){//第二级
				Resource r = iter2.next();
				if((t.getDataId()).equals(r.getParentId())){
					treeNode = getTreeNode(r);
					if (null!=choosedSet&&choosedSet.contains(r.getId())) {
						treeNode.setChecked(true);
					} else {
						treeNode.setChecked(false);
					}
					t.children.add(treeNode);
//					iter2.remove();
					
					
					for(Iterator<Resource> iter3 = list.iterator();iter3.hasNext();){//第三级
						Resource r3 = iter3.next();
						if((treeNode.getDataId()).equals(r3.getParentId())){
							TreeNode t3 = getTreeNode(r3);
							if (null!=choosedSet&&choosedSet.contains(r3.getId())) {
								t3.setChecked(true);
							} else {
								t3.setChecked(false);
							}
							treeNode.children.add(t3);
//							iter3.remove();
						}	
					}
					
				}
			}
		}
		
		return trees;
	}
	
	public static TreeNode getTreeNode(Resource res){
		TreeNode treeNode = new TreeNode();
		treeNode.setDataId(res.getId());
		treeNode.setText(res.getName());
		treeNode.setUrl(res.getUrl());
		return treeNode;
	}
	

	public static List<TreeNode> getTreeNodesByCategory(List<Category> list,Set<Integer> choosedSet){
		List<TreeNode> trees = new ArrayList<TreeNode>(0);
		TreeNode treeNode = null;
		for(Iterator<Category> iter = list.iterator();iter.hasNext();){
			Category r = iter.next();
			if (r.getParentId() == 0) {
				treeNode = getTreeNodeByCategory(r);
				if (null!=choosedSet&&choosedSet.contains(r.getId())) {
					treeNode.setChecked(true);
				} else {
					treeNode.setChecked(false);
				}
				trees.add(treeNode);
				iter.remove();
			}
		}
		
		System.out.println("iter.size;"+list.size());
		for(TreeNode t:trees){
			for(Iterator<Category> iter2 = list.iterator();iter2.hasNext();){//第二级
				Category r = iter2.next();
				if((t.getDataId()).equals(r.getParentId())){
					treeNode = getTreeNodeByCategory(r);
					if (null!=choosedSet&&choosedSet.contains(r.getId())) {
						treeNode.setChecked(true);
					} else {
						treeNode.setChecked(false);
					}
					t.children.add(treeNode);
//					iter2.remove();
					
					
					for(Iterator<Category> iter3 = list.iterator();iter3.hasNext();){//第三级
						Category r3 = iter3.next();
						if((treeNode.getDataId()).equals(r3.getParentId())){
							TreeNode t3 = getTreeNodeByCategory(r3);
							if (null!=choosedSet&&choosedSet.contains(r3.getId())) {
								t3.setChecked(true);
							} else {
								t3.setChecked(false);
							}
							treeNode.children.add(t3);
//							iter3.remove();
						}	
					}
					
				}
			}
		}
		
		return trees;
	}
	
	public static TreeNode getTreeNodeByCategory(Category res){
		TreeNode treeNode = new TreeNode();
		treeNode.setDataId(res.getId());
		treeNode.setText(res.getName());
		return treeNode;
	}
}
