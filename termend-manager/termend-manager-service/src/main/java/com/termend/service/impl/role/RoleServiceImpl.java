package com.termend.service.impl.role;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.mapper.SysRoleMapper;
import com.termend.mapper.SysRoleRightMapper;
import com.termend.mapper.SysUserMapper;
import com.termend.pojo.SysRole;
import com.termend.pojo.SysRoleRightExample;
import com.termend.pojo.SysUserExample;
import com.termend.service.role.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysRoleRightMapper roleRightMapper;
	
	
	@Override
	public List<SysRole> findAllRoles() {

		return roleMapper.selectByExample(null);
	}

	
	@Override
	public void deleteAllByRoleId(Long roleId) {
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andUsrRoleIdEqualTo(roleId);
		userMapper.deleteByExample(userExample);
		SysRoleRightExample rrExample = new SysRoleRightExample();
		rrExample.createCriteria().andRfRoleIdEqualTo(roleId);
		roleRightMapper.deleteByExample(rrExample);
		roleMapper.deleteByPrimaryKey(roleId);
		
	}


	@Override
	public void saveSysRole(SysRole role) {
		// TODO Auto-generated method stub
		roleMapper.insert(role);
	}


	@Override
	public Object findSysRoleById(Long roleId) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleId);
	}


	@Override
	public void updateSysRole(SysRole role) {
		// TODO Auto-generated method stub
		roleMapper.updateByPrimaryKey(role);
	}

}
