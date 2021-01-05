package com.foodPlaza.dao;

import java.util.ArrayList;

import com.foodPlaza.Pojo.Order;

public interface OrderDao 
{
	boolean placeOrder(String custEmailID);
	boolean deleteOrder(int orderID);
	boolean clearOrder(String custEmailID); 
	ArrayList<Order> showAllOrder();
	ArrayList<Order> showAllOrder(String custEmailID);
}
