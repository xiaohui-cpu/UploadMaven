package com.termend.service.cart;



import java.util.List;

import com.termend.common.Cart;



/**
 * 购物车相关操作的服务类接口
 * 
 * @author yubaojin
 *
 */
public interface CartService {
	List<Cart> getAllCart(String openid);

	void addCart(String openid, int diskId);

	void substractCart(String openid, int diskId);

	void changeSelected(String openid, int diskId);

	void delCartByDiskId(String openid, int diskId);

	List<Cart> getSelectedCart(String openid);

	void delSelectedCart(String openid);
}
