package com.termend.service.role;

import java.util.List;

import com.termend.pojo.SysRoleRightKey;



public interface IRoleRightService{

	List<SysRoleRightKey> findRightsByRoleId(Long roleId);

	void manage(Long roleId, String[] selectedRights);

}
