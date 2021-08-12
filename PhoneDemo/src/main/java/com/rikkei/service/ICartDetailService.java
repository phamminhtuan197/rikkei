package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.CartDetail;

public interface ICartDetailService {
	List<CartDetail> getByCartId(Long id);
	
	Long getCount(Long id);
	
	CartDetail getCartDetail (long id);
	
	void createCartDetail(CartDetail cartDetail);
	
	void updateCartDetail(CartDetail cartDetail);
	
	void deleteCartDetail(long id);
}
