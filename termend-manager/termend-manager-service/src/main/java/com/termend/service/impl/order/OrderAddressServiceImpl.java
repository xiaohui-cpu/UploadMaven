package com.termend.service.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.termend.mapper.OrderAddressMapper;
import com.termend.pojo.Address;
import com.termend.pojo.OrderAddress;
import com.termend.pojo.OrderAddressExample;
import com.termend.pojo.OrderAddressExample.Criteria;
import com.termend.service.address.IAddressService;
import com.termend.service.order.IOrderAddressService;

@Service
public class OrderAddressServiceImpl implements IOrderAddressService{

	@Autowired
	private OrderAddressMapper orderAddrMapper;

	@Autowired
	private IAddressService addrService;

	/**
	 * 保存订单地址
	 */
	@Override
	public void saveAddress(String orderId, Integer selectedAddrId) {
		Address address = addrService.getAddrByAddrId(selectedAddrId);
		OrderAddress orderAddr = new OrderAddress();
		orderAddr.setAddress(address.getAddress());
		orderAddr.setGender(address.getGender());
		orderAddr.setMobile(address.getMobile());
		orderAddr.setName(address.getName());
		orderAddr.setOrderId(orderId);
		// 保存到数据库
		orderAddrMapper.insert(orderAddr);
	}

	/**
	 * 根据订单id得到订单收件人地址
	 */
	@Override
	public OrderAddress getAddressByOrderId(String orderId) {
		OrderAddressExample example = new OrderAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrderAddress> list = orderAddrMapper.selectByExample(example);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
	
	
}
