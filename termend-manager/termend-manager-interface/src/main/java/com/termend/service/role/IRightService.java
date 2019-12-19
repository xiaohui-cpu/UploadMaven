package com.termend.service.role;



import java.util.List;

import com.termend.pojo.SysRight;


public interface IRightService{

	List<SysRight> findAllRights();

	String createCode(String rightParentCode);

	void saveSysRight(SysRight right);
	
}
