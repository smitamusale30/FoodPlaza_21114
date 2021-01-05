package com.foodPlaza.dao;

import java.util.ArrayList;

import com.foodPlaza.Pojo.Cart;

public interface CartDao 
{
	boolean addToCart(Cart cr);
	boolean deleteCart(int CartID);
	boolean clearCart(String custEmailID);
	//boolean updateCart(Cart cr);
	ArrayList<Cart> showAllCart(String custEmailID);
}
