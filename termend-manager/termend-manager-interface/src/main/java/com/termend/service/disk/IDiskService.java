package com.termend.service.disk;

import java.util.List;
import java.util.Map;

import com.termend.pojo.Disk;

public interface IDiskService{

	List<Disk> getDisksByMenuId(int menuId);

	Disk getDiskById(int diskId);

	Map<String, Object> getDiskList(int menuId, int page, int rows);

	void deleteByDiskIds(String ids);

	void save(Disk disk);

	void update(Disk disk);

	void up(String ids);

	void down(String ids);

	void updateAllDiskSellNum(int num);
}
