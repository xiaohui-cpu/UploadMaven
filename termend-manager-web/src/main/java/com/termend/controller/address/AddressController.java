package com.termend.controller.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.termend.common.Result;
import com.termend.pojo.Address;
import com.termend.service.address.IAddressService;
import com.termend.service.order.IOrderAddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	/**
	 * 根据用户id得到所有的地址列表
	 * 
	 * @param openid
	 * @return
	 */
//	@RequestMapping(value = "/getAddrsByOpenid", method = RequestMethod.GET)
	@RequestMapping("/getAddrsByOpenid")
	@ResponseBody
	public Result getAddrsByOpenid(String openid) {
		List<Address> list = addressService.getAddrsByOpenid(openid);
		return Result.ok(list);
	}

	/**
	 * 根据用户openid把该用户拥有的地址id为addrId的改为默认地址
	 * 
	 * @param addrId
	 * @param openid
	 * @return
	 */
	@RequestMapping("/changeDefaultAddr")
	@ResponseBody
	public Result changeDefaultAddr(String addrId, String openid) {
		int id = Integer.parseInt(addrId);
		addressService.changeDefaultAddr(id, openid);
		return Result.ok();
	}

	/**
	 * 得到用户id为openid的默认地址
	 * 
	 * @param openid
	 * @return
	 */
	@RequestMapping("/getDefaultAddr")
	@ResponseBody
	public Result getDefaultAddr(String openid) {
		Address address = addressService.getDefaultAddr(openid);
		return Result.ok(address);
	}

	/**
	 * 删除openid用户的addrId地址
	 * 
	 * @param openid
	 * @param addrId
	 * @return
	 */
	@RequestMapping("/delAddrByAddrId")
	@ResponseBody
	public Result delAddrByAddrId(String openid, Integer addrId) {
		addressService.delAddrByAddrId(openid, addrId);
		return Result.ok();
	}

	/**
	 * 根据用户id和地址信息增加一个地址 这里本来有个openid的 刚好地址里有openid属性 刚好放进去
	 * 
	 * @param openid
	 * @param address
	 * @return
	 */
	@RequestMapping("/addAddress")
	@ResponseBody
	public Result addAddress(Address address)throws Exception {
//		String name = new String(address.getName().getBytes("ISO-8859-1"), "UTF-8");
//		System.out.println("name="+name);
		addressService.addAddress(address);
		return Result.ok();
	}

	/**
	 * 通过地址id得到地址
	 * 
	 * @param addrId
	 * @return
	 */
	@RequestMapping("/getAddrByAddrId")
	@ResponseBody
	public Result getAddrByAddrId(Integer addrId) {
		Address address = addressService.getAddrByAddrId(addrId);
		return Result.ok(address);
	}

	/**
	 * 更新地址
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping("/updateAddress")
	@ResponseBody
	public Result updateAddress(Address address) {
		addressService.updateAddress(address);
		return Result.ok();
	}
	
	
	

}
