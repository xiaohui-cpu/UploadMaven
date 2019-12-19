package com.termend.service.role;


import java.util.List;

import com.termend.pojo.SysRole;


public interface IRoleService{

	List<SysRole> findAllRoles();

	void deleteAllByRoleId(Long roleId);

	void saveSysRole(SysRole role);

	Object findSysRoleById(Long roleId);

	void updateSysRole(SysRole role);

}
