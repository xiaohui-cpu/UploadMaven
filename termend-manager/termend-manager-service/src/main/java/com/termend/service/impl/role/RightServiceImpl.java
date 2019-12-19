package com.termend.service.impl.role;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.common.support.StrUtil;
import com.termend.mapper.SysRightMapper;
import com.termend.pojo.SysRight;
import com.termend.pojo.SysRightExample;
import com.termend.service.role.IRightService;



@Service
public class RightServiceImpl  implements IRightService {

	@Autowired
	private SysRightMapper rightMapper;
	

	
	@Override
	public List<SysRight> findAllRights() {
		// TODO Auto-generated method stub
		return rightMapper.selectByExample(null);
	}

	@Override
	public String createCode(String rightParentCode) {
		SysRightExample example = new SysRightExample();
		example.createCriteria().andRightParentCodeEqualTo(rightParentCode);
		int num = rightMapper.selectByExample(example).size()+1;
		return StrUtil.createId(rightParentCode, num);
	}

	@Override
	public void saveSysRight(SysRight right) {
		// TODO Auto-generated method stub
		rightMapper.insert(right);
	}

	
	

}
