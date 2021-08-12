package com.rikkei.service;

import com.rikkei.entity.Cart;

public interface ICartService {
	
	Cart getCartUser(long id);
	
	void updateCartByUser(long id, Cart cart);
}	
