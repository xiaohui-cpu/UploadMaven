package com.termend.service.impl.disk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.termend.mapper.DiskMapper;
import com.termend.mapper.MenuMapper;
import com.termend.pojo.Disk;
import com.termend.pojo.DiskExample;
import com.termend.pojo.DiskExample.Criteria;
import com.termend.pojo.Menu;
import com.termend.service.disk.IDiskService;





/**
 * 商品服务实现类
 */
@Service
public class DiskServiceImpl implements IDiskService{

	@Autowired
	private DiskMapper diskMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Disk> getDisksByMenuId(int menuId) {
		
		DiskExample example = new DiskExample();
		Criteria criteria = example.createCriteria();
		if (menuId != 1) {
			criteria.andMenuIdEqualTo(menuId);
		}
		return diskMapper.selectByExample(example);

	}

	@Override
	public Disk getDiskById(int diskId) {
		return diskMapper.selectByPrimaryKey(diskId);
	}

	@Override
	public Map<String, Object> getDiskList(int menuId, int page, int rows) {
		//Page<Disk> pageInfo = PageHelper.startPage(page, rows);
		Map<String, Object> map = new HashMap<>();
		DiskExample example = new DiskExample();
		Criteria criteria = example.createCriteria();
		if (menuId > 1) {
			criteria.andMenuIdEqualTo(menuId);
		}
		PageHelper.startPage(page, rows);
		List<Disk> list = diskMapper.selectByExample(example);
		Page<Disk> pageInfo = (Page<Disk>) list;
		
		for (Disk disk : list) {
			Menu menu = menuMapper.selectByPrimaryKey(disk.getMenuId());
			
			if (menu != null) {
				disk.setMenu(menu.getTitle());
			} else {
				disk.setMenu("<span style=\"color:red;\">未分类</span>");
			}

		}
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}

	/**
	 * 删除该菜单
	 */
	@Override
	public void deleteByDiskIds(String ids) {
		String[] idss = ids.split(",");
		for (String id : idss) {
			int iid = Integer.parseInt(id);
			diskMapper.deleteByPrimaryKey(iid);
		}
	}

	@Override
	public void save(Disk disk) {
		disk.setCreated(new Date());
		disk.setUpdated(new Date());
		disk.setSellnum(0);
		disk.setStatus(1);
		diskMapper.insert(disk);
	}

	@Override
	public void update(Disk disk) {
		Disk disk2 = diskMapper.selectByPrimaryKey(disk.getId());

		disk.setUpdated(new Date());
		disk.setStatus(1);
		disk.setCreated(disk2.getCreated());
		disk.setSellnum(disk2.getSellnum());
		if (disk.getMenuId() == null) {
			disk.setMenuId(disk2.getMenuId());
		}
		diskMapper.updateByPrimaryKey(disk);
	}

	@Override
	public void up(String ids) {
		String[] idss = ids.split(",");
		for (String id : idss) {
			int iid = Integer.parseInt(id);
			Disk disk = diskMapper.selectByPrimaryKey(iid);
			disk.setStatus(1);
			disk.setUpdated(new Date());
			diskMapper.updateByPrimaryKey(disk);
		}
	}

	@Override
	public void down(String ids) {
		String[] idss = ids.split(",");
		for (String id : idss) {
			int iid = Integer.parseInt(id);
			Disk disk = diskMapper.selectByPrimaryKey(iid);
			disk.setStatus(3);
			disk.setUpdated(new Date());
			diskMapper.updateByPrimaryKey(disk);
		}
	}

	/**
	 *设置所有商品销售数量 每月清零用
	 */
	@Override
	public void updateAllDiskSellNum(int num) {
		Disk disk = new Disk();
		disk.setSellnum(num);
		diskMapper.updateByPrimaryKey(disk);
	}
}
