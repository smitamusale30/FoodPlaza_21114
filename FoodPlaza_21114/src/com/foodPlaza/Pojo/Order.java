package com.foodPlaza.Pojo;

public class Order 
{
	private int orderID;
	private String custAddress;
	private double totalPrice;
	private String custEmailID;
	private String orderDate;
	
	public Order()
	{
	}
	public Order(int orderID, String foodName, String custAddress, double totalPrice, String custEmailID, String orderDate) 
	{
		this.orderID = orderID;
		this.custAddress = custAddress;
		this.totalPrice = totalPrice;
		this.custEmailID = custEmailID;
		this.orderDate = orderDate;
	}

	public int getOrderID() 
	{
		return orderID;
	}
	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}
	
	public String getCustAddress() 
	{
		return custAddress;
	}
	public void setCustAddress(String custAddress) 
	{
		this.custAddress = custAddress;
	}
	public double getTotalPrice() 
	{
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) 
	{
		this.totalPrice = totalPrice;
	}
	public String getCustEmailID() 
	{
		return custEmailID;
	}
	public void setCustEmailID(String custEmailID) 
	{
		this.custEmailID = custEmailID;
	}
	public String getOrderDate() 
	{
		return orderDate;
	}
	public void setOrderDate(String orderDate) 
	{
		this.orderDate = orderDate;
	}

	@Override
	public String toString() 
	{
		return "Order [orderID=" + orderID + ", custAddress=" + custAddress + ", totalPrice="
				+ totalPrice + ", custEmailID=" + custEmailID + ", orderDate=" + orderDate + "]";
	}

	
}
