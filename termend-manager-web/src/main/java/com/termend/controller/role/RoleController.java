package com.termend.controller.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.termend.pojo.SysRight;
import com.termend.pojo.SysRole;
import com.termend.pojo.SysUser;
import com.termend.service.role.IRightService;
import com.termend.service.role.IRoleRightService;
import com.termend.service.role.IRoleService;
import com.termend.service.user.IUserService;


@Controller
@RequestMapping("role")
public class RoleController {

	@Resource
	private IUserService userService;
	
	@Resource
	private IRoleService roleService;
	
	@Resource
	private IRightService rightService;
	
	@Resource
	private IRoleRightService roleRightService;
	
	@RequestMapping("userList") // role/userList.action
	public String userList(Model model) {
		List<SysUser> userList = userService.findAllUsers();
		model.addAttribute("userList", userList);
		return "role/user/list";
	}
	
	
	@RequestMapping("toUserAdd") // role/userList.action
	public String toUserAdd(Model model) {
		List<SysRole> roleList = roleService.findAllRoles();
		model.addAttribute("roleList", roleList);
		return "role/user/add";
	}
	
	
	@RequestMapping("userAdd") // role/userList.action
	public String userAdd(SysUser user) {
		userService.selectUser(user);
		return "redirect:../role/userList.action";
	}
	
	@RequestMapping("toUserEdit") // role/userList.action
	public String toUserEdit(Long usrId,Model model) {
		
		List<SysRole> roleList = roleService.findAllRoles();
		model.addAttribute("roleList", roleList);
		model.addAttribute("sysUser", userService.findUserById(usrId));
		return "role/user/edit";
	}
	
	@RequestMapping("userEdit") // role/userList.action
	public String userEdit(SysUser user) {
		userService.updateUser(user);
		return "redirect:../role/userList.action";
	}
	
	@RequestMapping("userDelete") // role/userList.action
	public String userDelete(Long usrId) {
		userService.deleteByUsrId(usrId);
		return "redirect:../role/userList.action";
	}
	
	

	@RequestMapping("roleList") // role/roleList.action
	public String roleList(Model model) {
		List<SysRole> roleList = roleService.findAllRoles();
		model.addAttribute("roleList", roleList);
		return "role/role/list";
	}
	
	@RequestMapping("toRoleAdd") // role/userList.action
	public String toRoleAdd(Model model) {
		return "role/role/add";
	}
	
	
	
	@RequestMapping("roleAdd") // role/userList.action
	public String roleAdd(SysRole role) {
		roleService.saveSysRole(role);
		return "redirect:../role/roleList.action";
	}
	
	@RequestMapping("toRoleEdit") // role/userList.action
	public String toRoleEdit(Long roleId,Model model) {	
		model.addAttribute("sysRole", roleService.findSysRoleById(roleId));
		return "role/role/edit";
	}
	
	@RequestMapping("roleEdit") // role/userList.action
	public String roleEdit(SysRole role) {
		roleService.updateSysRole(role);
		return "redirect:../role/roleList.action";
	}
	
	
	//=========================
	@RequestMapping("toRoleManage") // role/userList.action
	public String toRoleManage(Long roleId,Model model) {	
		model.addAttribute("sysRole", roleService.findSysRoleById(roleId));
		model.addAttribute("sysRightList", rightService.findAllRights());
		model.addAttribute("sysRoleRightList", roleRightService.findRightsByRoleId(roleId));
		return "role/role/manage";
	}
	
	
	@RequestMapping("roleManage") // role/userList.action
	public String roleManage(Long roleId,String[] selectedRights,Model model) {	
		roleRightService.manage(roleId,selectedRights);
		return "redirect:../role/roleList.action";
	}
	
	
	@RequestMapping("roleDelete") // role/userList.action
	public String roleDelete(Long roleId) {	
		roleService.deleteAllByRoleId(roleId);
		return "redirect:../role/roleList.action";
	}
	
	//==============================================================================
	@RequestMapping("rightList") 
	public String rightList(Model model) {
		List<SysRight> rightList = rightService.findAllRights();
		model.addAttribute("rightList", rightList);
		return "role/right/list";
	}
	
	@RequestMapping("toRightAdd") 
	public String toRightAdd(SysRight right,Model model) {
		model.addAttribute("right",right);
		return "role/right/add";
	}
	
	
	@RequestMapping("rightAdd") 
	public String rightAdd(SysRight right,Model model) {
		String code = rightService.createCode(right.getRightParentCode());
		right.setRightCode(code);
		right.setRightTip(right.getRightText());
		rightService.saveSysRight(right);
		return "redirect:../role/rightList.action";
	}
}
