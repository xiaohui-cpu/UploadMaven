package com.termend.controller.user;



import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.termend.common.Result;
import com.termend.common.json.JsonUtils;
import com.termend.pojo.SysRight;
import com.termend.pojo.SysUser;
import com.termend.service.user.IUserService;



@Controller
public class UserController {

	@Resource
	private IUserService userService;
	
	

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/toLogin")
	@ResponseBody
	public Result toLogin(SysUser sysUser, HttpSession session) {
		SysUser user = userService.selectUser(sysUser);
		if(user!=null) {
			session.setAttribute("username",user.getUsrName());
			return Result.ok();
		}
		return Result.error("用户名或密码错误！");
	}

	@RequestMapping("/loginout")
	@ResponseBody
	public void loginOut(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/toIndex")
	public String index(Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		model.addAttribute("username", username);
		//如果直接返回字符串，视图解析器会转成物理视图
		SysUser user = userService.selectUserByUserName(username);
		List<SysRight> rights = userService.selectUserRights(user);
		
		String str = "[";
		for (int i = 0;i<rights.size();i++) {
			if(i<rights.size()-1) {
				str = str + JsonUtils.objectToJson(rights.get(i))+",";
			}else {
				str = str + JsonUtils.objectToJson(rights.get(i));
			}
		}
		str =str+"]";
		
		//System.out.println(str);
		session.setAttribute("lists",str);
		return "index";
	}

	@RequestMapping("pages/{pageName}")
	public String toPage(@PathVariable("pageName") String pageName) {
		return pageName;
	}

}
