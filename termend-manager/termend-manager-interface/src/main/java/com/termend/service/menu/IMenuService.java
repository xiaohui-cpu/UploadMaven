package com.termend.service.menu;

import java.util.List;

import com.termend.common.TreeNode;
import com.termend.pojo.Menu;

public interface IMenuService {

	List<Menu> allMenu();
	List<TreeNode> getMenuList(Integer parentId);
	TreeNode addMenu(int parentId,String name);
	void update(int id, String name);
	void delete(Integer parentId,String id);
}
