package com.termend.service.order;

import com.termend.pojo.OrderAddress;

public interface IOrderAddressService {

	/**
	 * 保存订单地址
	 * 
	 * @param orderId
	 * @param openid
	 */
	void saveAddress(String orderId, Integer selectedAddrId);

	/**
	 * 根据订单id得到订单收件人地址
	 * 
	 * @param orderId
	 * @return
	 */
	OrderAddress getAddressByOrderId(String orderId);
}
