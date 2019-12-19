package com.termend.service.user;

import java.util.List;

import com.termend.pojo.SysRight;
import com.termend.pojo.SysUser;

public interface IUserService{

	SysUser selectUser(SysUser user);
	
	List<SysRight> selectUserRights(SysUser user);

	List<SysUser> findAllUsers();

	Object findUserById(Long usrId);

	void updateUser(SysUser user);

	void deleteByUsrId(Long usrId);

	SysUser selectUserByUserName(String username);

	
}
