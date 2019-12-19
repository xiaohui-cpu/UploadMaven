package com.termend.service.impl.role;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.mapper.SysRoleRightMapper;
import com.termend.pojo.SysRoleRightExample;
import com.termend.pojo.SysRoleRightKey;
import com.termend.service.role.IRoleRightService;


@Service
public class RoleRightServiceImpl implements IRoleRightService {

	@Autowired
	private SysRoleRightMapper roleRightMapper;
	
	
	@Override
	public List<SysRoleRightKey> findRightsByRoleId(Long roleId) {
		SysRoleRightExample example = new SysRoleRightExample();
		example.createCriteria().andRfRoleIdEqualTo(roleId);
		return roleRightMapper.selectByExample(example);
	}

	
	@Override
	public void manage(Long roleId, String[] selectedRights) {
		// TODO Auto-generated method stub
		SysRoleRightExample example = new SysRoleRightExample();
		example.createCriteria().andRfRoleIdEqualTo(roleId);
		roleRightMapper.deleteByExample(example);
		
		for (String right : selectedRights) {
			SysRoleRightKey roleRight = new SysRoleRightKey();
			roleRight.setRfRoleId(roleId);
			roleRight.setRfRightCode(right);
			roleRightMapper.insert(roleRight);
		}
	}

	

	
	

}
