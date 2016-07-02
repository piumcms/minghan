package com.cloudeasy.utils;

import java.util.ArrayList;
import java.util.List;

import com.cloudeasy.bean.TreeNode;
import com.cloudeasy.model.Resource;

/**
 * 后台左菜单显示
 * @Title: TreeUtil 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:08:55 
 * @version V1.0
 */
public class TreeUtil {
	private final static String MENU_ID = "menu_";
	
	List<Resource> rootMenus;
	List<Resource> childMenus;
	
	public TreeUtil(List<Resource> rootMenus,List<Resource> childMenus){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
	}  
	
	/*public TreeUtil(List<SysMenu> rootMenus,List<SysMenu> childMenus,List<SysMenuBtn> childBtns){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
		this.childBtns = childBtns;
	}  */
	
	public List<TreeNode> getTreeNode(){
		return getRootNodes();
	}
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode MenuToNode(Resource menu){
		if(menu == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(MENU_ID+menu.getId());
		node.setDataId(menu.getId());
		node.setText(menu.getName());
		node.setUrl(menu.getUrl());
		node.setParentId(menu.getParentId());
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", menu.getId());
		return node;
	}
	
	

	private List<TreeNode> getRootNodes(){
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for(Resource menu : rootMenus){
			TreeNode node = MenuToNode(menu);
			if(node != null){
				addChlidNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private void addChlidNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		for(Resource menu : childMenus){
			if(rootNode.getDataId().equals(menu.getParentId())){
				TreeNode node = MenuToNode(menu);
				childNodes.add(node);
			}
		}
		rootNode.setChildren(childNodes);
	}
	
}
