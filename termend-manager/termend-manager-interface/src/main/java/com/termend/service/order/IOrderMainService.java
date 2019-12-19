package com.termend.service.order;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


import com.termend.common.OrderDetail;
import com.termend.common.OrderSample;
import com.termend.common.Statistics;
import com.termend.common.sql.Query;
import com.termend.pojo.OrderMain;

public interface IOrderMainService {

	/**
	 * 保存订单OrderMain 并返回orderId
	 * 
	 * @param openid
	 * @param totalMoney
	 * @param remarks
	 * @return orderId
	 */
	String saveOrder(String openid, String totalMoney, String remarks, int selectedAddrId);

	/**
	 * 改变订单状态
	 * 
	 * @param orderId
	 * @param flag
	 */
	void changeStatus(String orderId, int flag);

	List<OrderSample> getAllOrderSample(String openid);

	OrderDetail getOrderDetailByOrderId(String orderId);

	List<OrderMain> getOrderByStutus(int status);

	/**
	 * 更新orderMain
	 */
	void updateOrder(OrderMain orderMain);
	/**
	 * 商家得到订单列表
	 * @return
	 */
	Map<String,Object> getOrders(int page,int rows,int status);
	
	/**
	 * 得到统计
	 */
	Statistics getStatistics(Query query) throws ParseException;
	
}
