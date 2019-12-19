package com.termend.service.impl.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.common.TreeNode;
import com.termend.mapper.MenuMapper;
import com.termend.pojo.Menu;
import com.termend.pojo.MenuExample;
import com.termend.pojo.MenuExample.Criteria;
import com.termend.service.menu.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * 得到所有的菜单
	 */
	@Override
	public List<Menu> allMenu() {
		MenuExample example = new MenuExample();
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<TreeNode> getMenuList(Integer parentId) {
		MenuExample example = new MenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Menu> list = menuMapper.selectByExample(example);
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (Menu menu : list) {
			TreeNode node = new TreeNode();
			node.setId(menu.getId());
			node.setText(menu.getTitle());
			node.setState(menu.getIsParentid() == 1 ? "closed" : "open");
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public TreeNode addMenu(int parentId, String name) {
		Menu menu = new Menu();
		menu.setParentId(parentId);
		menu.setIsParentid(0);
		menu.setTitle(name);
		menuMapper.insert(menu);
		TreeNode node = new TreeNode();
//		MenuExample example = new MenuExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andTitleEqualTo(name);
//		Menu menuNext = menuMapper.selectByExample(example).get(0);
//		System.out.println(menu.getTitle());
//		node.setId(menuNext.getId());
		node.setText(menu.getTitle());
		node.setState("open");
		return node;
	}

	@Override
	public void update(int id, String name) {
		Menu menu = menuMapper.selectByPrimaryKey(id);
		menu.setTitle(name);
		menuMapper.updateByPrimaryKey(menu);
	}

	@Override
	public void delete(Integer parentId,String id) {
		menuMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

	
}
