package com.termend.service.impl.user;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.mapper.SysUserMapper;
import com.termend.pojo.SysRight;
import com.termend.pojo.SysUser;
import com.termend.pojo.SysUserExample;
import com.termend.pojo.SysUserExample.Criteria;
import com.termend.service.user.IUserService;



@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private SysUserMapper userMapper;
	
	
	@Override
	public List<SysRight> selectUserRights(SysUser user) {
		
		return userMapper.selectUserRights(user);
	}

	
	@Override
	public List<SysUser> findAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.findAllUsers();
	}


	@Override
	public SysUser selectUser(SysUser user) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(user);
	}


	@Override
	public Object findUserById(Long usrId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(usrId);
	}


	@Override
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
	}


	@Override
	public void deleteByUsrId(Long usrId) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(usrId);
	}


	@Override
	public SysUser selectUserByUserName(String username) {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsrNameEqualTo(username);
		return userMapper.selectByExample(example).get(0);
	}

}
